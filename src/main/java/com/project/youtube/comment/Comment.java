package com.project.youtube.comment;

import com.project.youtube.user.User;
import com.project.youtube.video.Video;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    @Size(max = 10000, message = "{validation.name.size.too_long}")
    @NotBlank
    private String content;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video belongsTo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User commentBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
