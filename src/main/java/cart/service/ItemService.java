package cart.service;

import cart.domain.ImageUrl;
import cart.domain.Name;
import cart.domain.Price;
import cart.controller.dto.ItemRequest;
import cart.controller.dto.ItemResponse;
import cart.dao.ItemDao;
import cart.domain.Item;
import cart.exception.NotFoundResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<ItemResponse> loadAllItem() {
        List<Item> allItem = itemDao.findAll();
        return allItem.stream()
                      .map(ItemResponse::from)
                      .collect(Collectors.toList());
    }

    public ItemResponse loadItem(final Long itemId) {
        Optional<Item> findItem = itemDao.findBy(itemId);
        return ItemResponse.from(findItem.orElseThrow());
    }

    public Long saveItem(final ItemRequest itemRequest) {
        Item item = new Item.Builder()
                .name(new Name(itemRequest.getName()))
                .imageUrl(new ImageUrl(itemRequest.getImageUrl()))
                .price(new Price(itemRequest.getPrice()))
                .build();
        return itemDao.save(item);
    }

    public void updateItem(final Long itemId, final ItemRequest itemRequest) {
        validateExistItem(itemId);
        Item item = new Item.Builder()
                .id(itemId)
                .name(new Name(itemRequest.getName()))
                .imageUrl(new ImageUrl(itemRequest.getImageUrl()))
                .price(new Price(itemRequest.getPrice()))
                .build();
        itemDao.update(item);
    }

    public void deleteItem(final Long itemId) {
        validateExistItem(itemId);
        itemDao.deleteBy(itemId);
    }

    private void validateExistItem(Long itemId) {
        Optional<Item> findItem = itemDao.findBy(itemId);
        if (findItem.isEmpty()) {
            throw new NotFoundResultException("존재하지 않는 아이템 입니다.");
        }
    }
}