package com.example.planstudiow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Api {

    @Autowired
    private HarmonogramDB harmonogramDB;

    @PostMapping(value = "harmonogram",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewItem(@RequestBody Harmonogram element){
        harmonogramDB.addItem(element);
    }

    @GetMapping(value = "harmonogram",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Harmonogram> getHarmonogram(
            @Nullable @RequestParam("id") Integer id,
            @Nullable @RequestParam("subject") String subject,
            @Nullable @RequestParam("score") Integer score,
            @Nullable @RequestParam("room") String room,
            @Nullable @RequestParam("exam") Boolean exam){
        return harmonogramDB.getItemList(id, subject, score, room, exam);
    }

    @DeleteMapping(value = "harmonogram")
    public void deleteAll(){
        harmonogramDB.deleteAll();
    }

    @GetMapping(value = "harmonogram/{exam}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getItemByExam(@PathVariable(value="exam") Boolean exam){
        Harmonogram harmonogram = harmonogramDB.getItemByExam(exam);
        if (harmonogram == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(harmonogram);
    }

    @GetMapping(value = "harmonogram/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getItemById(@PathVariable(value="id") Integer id){
        Harmonogram harmonogram = harmonogramDB.getItemById(Integer.valueOf(id));
        if (harmonogram == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(harmonogram);
    }

    @DeleteMapping(value = "harmonogram/{id}")
    public ResponseEntity deleteById(@PathVariable(value="id") Integer id){
        if (harmonogramDB.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Test połączenia
    @GetMapping("ping")
    public String lorem(){
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Enim nunc faucibus a pellentesque sit amet. Quis hendrerit dolor magna eget. Pellentesque id nibh tortor id aliquet lectus proin. Mattis ullamcorper velit sed ullamcorper morbi. Mauris pellentesque pulvinar pellentesque habitant morbi tristique. Aliquam etiam erat velit scelerisque in dictum non consectetur. Sit amet mattis vulputate enim nulla aliquet porttitor. Ut ornare lectus sit amet est placerat in egestas. Sed faucibus turpis in eu mi bibendum neque. Nibh sit amet commodo nulla facilisi nullam vehicula. Nibh praesent tristique magna sit amet purus. Commodo elit at imperdiet dui accumsan sit amet nulla facilisi. Scelerisque purus semper eget duis at tellus at urna condimentum. Condimentum lacinia quis vel eros donec. Nunc consequat interdum varius sit amet.";
    }

    //Przykładowe zapytanie
    @GetMapping(value = "getTest",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public HarmonogramDto getPlan(){
        return new HarmonogramDto(1001, "TAW", 2, "216", true);
    }
}
