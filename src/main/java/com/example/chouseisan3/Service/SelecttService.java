//package com.example.chouseisan3.Service;
//
//import com.example.chouseisan3.Model.Selectt;
//import com.example.chouseisan3.Repository.SelecttRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//public class SelecttService implements ISelecttService {
//    @Autowired
//    private SelecttRepository selecttRepository;
//    @Override
//    public Iterable<Selectt> numberOfTick() {
//        return selecttRepository.numberOfTick();
//    }
//
//    @Override
//    public Iterable<Selectt> numberOfQuestionMark() {
//        return selecttRepository.numberOfQuestionMark();
//    }
//
//    @Override
//    public Iterable<Selectt> numberOfRefuse() {
//        return selecttRepository.numberOfRefuse();
//    }
//
//    @Override
//    public void save(Selectt selectt) {
//        selecttRepository.save(selectt);
//    }
//
//    @Override
//    public Iterable<Selectt> findAll() {
//        return selecttRepository.findAll();
//    }
//
//    @Override
//    public Optional<Selectt> findById(Long id) {
//        return selecttRepository.findById(id);
//    }
//
//    @Override
//    public void remove(Long id) {
//        selecttRepository.deleteById(id);
//    }
//}
