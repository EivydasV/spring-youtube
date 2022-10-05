package com.project.youtube.channel;

import com.project.youtube.user.User;
import com.project.youtube.video.Video;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "channels")
@Data
public class Channel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "channel")
    private Set<Video> videos;
}
