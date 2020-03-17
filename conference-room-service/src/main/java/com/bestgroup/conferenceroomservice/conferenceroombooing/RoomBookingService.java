package com.bestgroup.conferenceroomservice.conferenceroombooing;

import com.bestgroup.conferenceroomservice.ConferenceRoom;
import com.bestgroup.conferenceroomservice.ConferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomBookingService {

    private RoomBookingRepository roomBookingRepository;
    private ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public RoomBookingService(RoomBookingRepository roomBookingRepository,ConferenceRoomRepository conferenceRoomRepository) {
        this.roomBookingRepository = roomBookingRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    public void createRoomBooking(RoomBooking roomBooking) {
        roomBookingRepository.save(roomBooking);

        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(roomBooking.getRoomId());
        optionalConferenceRoom.get().addRoomBookings(roomBooking);
        conferenceRoomRepository.save(optionalConferenceRoom.get());

        //TODO: ask guys if this will be called from USER Microservice or by enduser
         }

    public List<RoomBooking> getRoomBookings(int id) {

        Optional<ConferenceRoom> optionalConferenceRoom = conferenceRoomRepository.findById(id);
        //TODO: call USER microservice to get info about user connected with booking
        //TODO: then change the retrun structure

        return optionalConferenceRoom.get().getRoomBookings();
    }
}