package com.tinqin.zoostore.core.processor.multimedia;

import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaOperationProcessorSingleItem;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResult;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllMultimediaOperationProcessor implements GetAllMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public GetAllMultimediaResult process(GetAllMultimediaInput request) {

            return GetAllMultimediaResult.builder()
                    .multimedia(this.multimediaRepository
                            .findAll()
                            .stream()
                            .map(this::mapMultimediaToGetAllMultimediaOperationProcessorSingleItem)
                            .toList())
                    .build();
        }


    private GetAllMultimediaOperationProcessorSingleItem mapMultimediaToGetAllMultimediaOperationProcessorSingleItem(Multimedia multimedia) {

        return GetAllMultimediaOperationProcessorSingleItem.builder()
                .id(multimedia.getId())
                .url(multimedia.getUrl())
                .build();
    }
}
