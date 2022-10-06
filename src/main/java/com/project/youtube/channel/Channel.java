package com.project.youtube.channel;

import com.project.youtube.user.User;
import com.project.youtube.video.Video;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
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
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "channel")
    private Set<Video> videos;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
