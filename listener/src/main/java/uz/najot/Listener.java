package uz.najot;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Listener {
    private final static ConnectionFactory connectionFactory = new ConnectionFactory();
    private static Channel channel=null;
    private final static String speedRoutingKey = "log.logic.speed";
    private final static String routingKey = "log.logic";

    public static void main(String[] args) {
        try (Connection connection = connectionFactory.newConnection(); ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]))){
            channel = connection.createChannel();
            while (true) {
                Socket socket = serverSocket.accept();
             new Publisher(socket);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //TODO queue tashlash kerak
        }
    }
    static class Publisher extends Thread implements AutoCloseable{
        private Socket socket;

        public Publisher(Socket socket){
            this.socket = socket;
            start();
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = inputStream.readAllBytes();
                String message = new String(bytes);
                publishMessage(message);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Ok".getBytes());
                outputStream.close();
                inputStream.close();
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        void publishMessage(String message) throws Exception{
            Map<String, Object> map = convertMessage(message);
            if (map!=null){
            Gson gson = new Gson();
            String json = gson.toJson(map);
                System.out.println(json);
                AMQP.BasicProperties builder = new AMQP.BasicProperties().builder().contentType("application/text").build();
                if (Double.parseDouble(String.valueOf(map.get("speed")))>70){
                channel.basicPublish("tracker_exchange",speedRoutingKey,builder,json.getBytes());
            }else {
                channel.basicPublish("tracker_exchange",routingKey,builder,json.getBytes());
            }
            }
        }
        Map<String, Object> convertMessage(String message){
            if(message.length()>0){
                String substring = message.substring(7, message.indexOf(" HTTP"));
                String[] split = substring.split("&");
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < split.length; i++) {
                    String s = split[i];
                    String[] strings = s.split("=");
                    map.put(strings[0],strings[1]);
                }
                return map;

            }
            return null;
        }


        @Override
        public void close() throws Exception {
            socket.close();
        }
    }
}