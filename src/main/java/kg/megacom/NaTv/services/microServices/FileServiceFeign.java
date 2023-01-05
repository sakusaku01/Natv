package kg.megacom.NaTv.services.microServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@FeignClient(name = "${micro.fileService.name}",url = "${micro.fileService.url}")
public interface FileServiceFeign {
    @Transactional(Transactional.TxType.REQUIRED )
    @PostMapping(value = "/file/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Photo storeFile(@RequestPart("file") MultipartFile multipartFile);
}
