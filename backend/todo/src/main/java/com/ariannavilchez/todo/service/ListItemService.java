package com.ariannavilchez.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ariannavilchez.todo.model.ListItem;
import com.ariannavilchez.todo.repository.ListItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;

    public List<ListItem> findAll(){
        return listItemRepository.findAll();
    }

    public ListItem findById(Long id){
        return listItemRepository.findById(id).orElse(null);
    }

    public ListItem save(ListItem listItem){
        return listItemRepository.save(listItem);
    }

    public ListItem completeListItem(Long id){
        ListItem existingListItem = findById(id);
        if(existingListItem != null){
            existingListItem.setCompleted(true);
            return listItemRepository.save(existingListItem);
        }
        return null;    
    }

    public ListItem restoreListItem(Long id){
        ListItem existingListItem = findById(id);
        if(existingListItem != null){
            existingListItem.setCompleted(false);
            return listItemRepository.save(existingListItem);
        }
        return null;
    }

    public ListItem update(Long id, ListItem listItem){
        ListItem existingListItem = findById(id);
        if(existingListItem != null){
            listItem.setId(id);
            return listItemRepository.save(listItem);
        }else{
            return null;
        }
    }

    public void delete(Long id){
        ListItem existingListItem = findById(id);
        if(existingListItem != null){
            listItemRepository.deleteById(id);
        }else{
            throw new RuntimeException("ListItem with id " + id + " not found");
        }
    }
}
