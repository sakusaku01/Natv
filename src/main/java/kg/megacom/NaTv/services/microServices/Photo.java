package kg.megacom.NaTv.services.microServices;

import lombok.Data;

@Data
public class Photo {
    private String fileName;
    private String downloadUri;
    private String fileType;
    private long size;

    public Photo(String fileName, String downloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.downloadUri = downloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}
