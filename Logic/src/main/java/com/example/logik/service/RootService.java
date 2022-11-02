package com.example.logik.service;

import com.example.logik.entity.History;
import com.example.logik.entity.Metres;
import com.example.logik.entity.RealTime;
import com.example.logik.model.Root;
import com.example.logik.repository.HistoryRepository;
import com.example.logik.repository.MetresRepository;
import com.example.logik.repository.RealTimeRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RootService {
    private final HistoryRepository historyRepository;
    private final RealTimeRepository realTimeRepository;
    private final MetresRepository metresRepository;
    final double RADIUS = 6371.01;
    public void saved(String message){
        Gson gson = new Gson();
        Root json = gson.fromJson(message,Root.class);
        History history = new History(json);
        RealTime realTime = new RealTime(json);

        Integer id = realTime.getId();
        Optional<RealTime> optional = realTimeRepository.findById(id);
        String lat = optional.get().getLat();
        String lon = optional.get().getLon();
        Double metres = metres(Double.parseDouble(lat), Double.parseDouble(lon), Double.parseDouble(json.getLat()), Double.parseDouble(json.getLon()));
        Metres metres1 = new Metres(json.getId(),json.getLat(),json.getLon(),metres);
        metresRepository.save(metres1);
        realTimeRepository.save(realTime);
        historyRepository.save(history);
    }
    public double metres(Double lat1,Double lon1,Double lat2,Double lon2)
    {
        Double R = 6.371; // km
        double dLat = lat2-lat1;
        double dLon = lon2-lon1;
        var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
    public double getMetres(Integer id){
        Optional<RealTime> realTime = realTimeRepository.findById(id);
        Optional<History> history = historyRepository.getHistory(id);
        String lat1 = realTime.get().getLat();
        String lon1 = realTime.get().getLon();
        String lat2 = history.get().getLat();
        String lon2 = history.get().getLon();
        return metres(Double.parseDouble(lat1), Double.parseDouble(lon1),
                Double.parseDouble(lat2), Double.parseDouble(lon2));
    }

}
