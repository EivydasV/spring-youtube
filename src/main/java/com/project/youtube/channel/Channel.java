package com.project.youtube.channel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.youtube.user.User;
import com.project.youtube.video.Video;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "channels")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Channel {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Size(max = 100, message = "{validation.name.size.too_long}")
    @NotBlank
    private String name;

    @OneToOne(mappedBy = "channel")
    private User user;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Video> videos;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Channel channel = (Channel) o;
        return id != null && Objects.equals(id, channel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
