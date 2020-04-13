package com.ui.fitit.data.model;

import com.google.firebase.firestore.CollectionReference;
import com.ui.fitit.Constants;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class User implements Serializable {
    String username;
    String hashedPassword;
    String fullName;
    long points;

    public void updatePoints(Long newPoints) {
        points += newPoints;
        if (points < 0) {
            points = 0L;
        }
    }

    public Long getLevel() {
        return 1 + points / Constants.POINTS_PER_LEVEL;
    }

    public Float getLevelProgress() {
        return (float) (points % Constants.POINTS_PER_LEVEL) / (float) Constants.POINTS_PER_LEVEL * 100;
    }

    public void updatePoints(Session session, Event event, CollectionReference users) {
        if (session.getAttendance() == Attendance.COMPLETED) {
            updatePoints(10L);
            users.document(username).set(this);
        }
    }
}
