package com.example.planstudiow;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope
public class HarmonogramDB {
    private List<Harmonogram> harmonogramList = new ArrayList<>();
    private int itemIndex = 1;

    public void addItem(Harmonogram element){
        element.setId(itemIndex);
        harmonogramList.add(element);
        itemIndex = itemIndex + 1;
    }

    public List<Harmonogram> getHarmonogramList() {
        return harmonogramList;
    }

    public List<Harmonogram> getItemList(Integer id, String subject, Integer score, String room, Boolean exam){
        if(score == null && exam == null){
            return harmonogramList;
        }
        List<Harmonogram> filteredHarmonogram = new ArrayList<>();
        for (Harmonogram harmonogram : harmonogramList){
            if (score == null && harmonogram.getExam().equals(exam)){
                filteredHarmonogram.add(harmonogram);
            } else if(exam == null && harmonogram.getScore().equals(score)){
                filteredHarmonogram.add(harmonogram);
            } else if(harmonogram.getScore().equals(score) && harmonogram.getExam().equals(exam)){
                filteredHarmonogram.add(harmonogram);
            }
        }
        return filteredHarmonogram;
    }

    public void deleteAll(){
        harmonogramList.clear();
    }

    public Harmonogram getItemByExam(Boolean exam){
        for(Harmonogram element : harmonogramList){
            if(element.getExam().equals(exam)){
                return element;
            }
        }
        return null;
    }

    public Harmonogram getItemById(Integer id){
        for(Harmonogram element : harmonogramList){
            if(element.getId().equals(id)){
                return element;
            }
        }
        return null;
    }

    public boolean deleteById(Integer id){
        Harmonogram itemToDelete = null;
        for(Harmonogram element : harmonogramList){
            if(element.getId().equals(id)){
                itemToDelete = element;
            }
        }
        if(itemToDelete == null){
            return false;
        }
        harmonogramList.remove(itemToDelete);
        return true;
    }
}
