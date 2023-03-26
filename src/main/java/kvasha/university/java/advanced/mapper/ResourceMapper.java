package kvasha.university.java.advanced.mapper;

import java.io.ByteArrayOutputStream;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    @SneakyThrows
    public Resource toResource(Workbook workbook) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return new ByteArrayResource(bytes);
    }
}
