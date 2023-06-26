package com.ems.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "attendance")
public class JpaAttendance implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private JpaUser user;

        @Column(name="created_at")
        private LocalDateTime createdAt;

        @Column(name="updated_at")
        private LocalDateTime updatedAt;


        public JpaAttendance(){

        }

        public JpaAttendance(JpaUser user){
            this.user = user;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setUser(JpaUser user){
            this.user = user;
        }

        public JpaUser getUser() {
            return user;
        }

        public void setCreatedAt(LocalDateTime dateTime) {
            this.createdAt = dateTime;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setUpdatedAt(LocalDateTime dateTime) {
            this.updatedAt = dateTime;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = LocalDateTime.now();
        }

        @Override
        public int hashCode() {
            return Objects.hash(createdAt, updatedAt, user);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JpaUser)) {
                return false;
            }
           JpaAttendance other = (JpaAttendance) obj;
            return Objects.equals(getCreatedAt(), other.getCreatedAt()) &&
                    Objects.equals(getUpdatedAt(), other.getUpdatedAt()) &&
                    Objects.equals(getUser(), other.getUser());
        }

        @Override
        public String toString() {
            return "{ " +
                    "user=" + user +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    " }";
        }
}

