package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.DefaultMapper;
import com.frterie.friterie.mapper.WorkerMapper;
import com.frterie.friterie.models.dto.WorkerDTO;
import com.frterie.friterie.models.dto.WorkerMiniDTO;
import com.frterie.friterie.models.entity.Purchase;
import com.frterie.friterie.models.entity.User;
import com.frterie.friterie.models.formAdd.WorkerForm;
import com.frterie.friterie.models.formUpdate.WorkerUpdateForm;
import com.frterie.friterie.repository.PurchaseRepository;
import com.frterie.friterie.repository.UserRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl extends DefaultServiceImplementation <WorkerDTO, WorkerMiniDTO, WorkerForm, WorkerUpdateForm, User, Integer> {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    protected WorkerServiceImpl (UserRepository repository, WorkerMapper mapper){
        super(repository, mapper);
    }

    @Override
    public List<WorkerDTO> getAll() {
        return repository.findAll()
                .stream()
                .filter(worker -> worker.getRole().equals("worker"))
                .map(mapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public WorkerMiniDTO insert(WorkerForm form) throws ElementNotFoundException {

        User toInsert = mapper.toEntity(form);

        toInsert.setRole("worker");

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);

    }


    @Override
    public WorkerDTO update(Integer id, WorkerUpdateForm form) throws ElementNotFoundException {

        User toUpdate = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        //Get all the variables of the updated form
        String name = form.getName();
        String username = form.getUsername();
        String password = form.getPassword();
        List<Integer> deliveryIDs = form.getDeliveryID();

        if (name != null){
            toUpdate.setName(name);
        }

        if (username != null){
            toUpdate.setUsername(username);
        }

        if (password != null){
            toUpdate.setPassword(password);
        }

        if (deliveryIDs.size() > 0){

            toUpdate.setDelivery(
                    deliveryIDs.stream()
                            .map(idPurchase -> purchaseRepository.findById(idPurchase).orElseThrow())
                            .collect(Collectors.toList())
            );

        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
