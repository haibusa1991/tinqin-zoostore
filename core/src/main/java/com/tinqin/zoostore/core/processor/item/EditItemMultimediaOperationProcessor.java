package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaOperation;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaInput;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResult;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.core.processor.utils.IdMismatchFinder;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemMultimediaOperationProcessor implements EditItemMultimediaOperation {
    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public EditItemMultimediaResult process(EditItemMultimediaInput input) {

        Item item = this.itemRepository.findById(input.getId()).orElseThrow(() -> new ItemNotFoundException(input.getId()));

        Set<Multimedia> multimedia = this.multimediaRepository.findAllByIdIn(input.getMultimediaIds());
        if (multimedia.size() != input.getMultimediaIds().size()) {
            throw new MultimediaNotFoundException(IdMismatchFinder.find(multimedia, input.getMultimediaIds()));
        }

        item.setMultimedia(multimedia);
        Item persisted = this.itemRepository.save(item);

        return EditItemMultimediaResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
