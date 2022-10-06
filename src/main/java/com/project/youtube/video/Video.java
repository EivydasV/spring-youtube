package com.project.youtube.video;

import com.github.slugify.Slugify;
import com.project.youtube.channel.Channel;
import com.project.youtube.comment.Comment;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String title;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String slug;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 5000, message = "{validation.name.size.too_long}")
    private String description;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 500, message = "{validation.name.size.too_long}")
    private String url;

    @Column(nullable = false)
    @NotNull
    @Positive
    private int duration;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @OneToMany(mappedBy = "video")
    private Set<Comment> comments;

    @PrePersist
    public void generateSlugForTitle() {
        final Slugify slugify = Slugify.builder().build();
        this.setSlug(slugify.slugify(this.getTitle()));
    }

//    private String publishedAt;
//
//    private String viewCount;
//    private String likeCount;
//    private String dislikeCount;
//    private String favoriteCount;
//    private String commentCount;

}
