package beans;

import java.util.Objects;

public class Song {
    private int id;
    private String name;
    private String artist;
    private String genre;
    private String album;
    private float duration;
    private String url;


    public Song(int id, String name, String artist, String genre, String album, float duration, String url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.duration = duration;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && Float.compare(song.duration, duration) == 0 && Objects.equals(name, song.name) && Objects.equals(artist, song.artist) && Objects.equals(genre, song.genre) && Objects.equals(album, song.album) && Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist, genre, album, duration, url);
    }
}
