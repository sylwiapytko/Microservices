package com.bestgroup.conferenceroomservice.conferenceroombooing;

import com.bestgroup.conferenceroomservice.ConferenceRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class RoomBooking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int roomBookingId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roomId")
    @Setter
    private ConferenceRoom conferenceRoom;

    @NotNull(message = "Field must not be empty.")
    @Future(message = "Date should be future")
    @Setter
    private Date startDateTime;

    @NotNull(message = "Field must not be empty.")
    @Future(message = "Date should be future")
    @Setter
    private Date endDateTime;

    //TODO validate room not occupied
}
