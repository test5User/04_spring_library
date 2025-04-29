package by.itclass.model.entities;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BookInLibrary {
    private String genre;
    private String author;
    private String title;
    private int pages;
    @NonNull private int library_id;
}
