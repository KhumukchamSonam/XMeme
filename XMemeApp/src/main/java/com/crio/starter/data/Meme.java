package com.crio.starter.data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "memes")
public class Meme {
    @Id
    private String id;
    private String name;
    private String url;
    private String caption;
    private LocalDateTime createdDate;
}
