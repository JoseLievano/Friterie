package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.CostumerMapper;
import com.frterie.friterie.models.dto.CostumerDTO;
import com.frterie.friterie.models.dto.CostumerMiniDTO;
import com.frterie.friterie.models.entity.User;
import com.frterie.friterie.models.formAdd.CostumerForm;
import com.frterie.friterie.models.formUpdate.CostumerUpdateForm;
import com.frterie.friterie.repository.PurchaseRepository;
import com.frterie.friterie.repository.UserRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerServiceImpl extends DefaultServiceImplementation <CostumerDTO, CostumerMiniDTO, CostumerForm, CostumerUpdateForm, User, Integer> {

    @Autowired
    private PurchaseRepository purchaseRepository;

    protected CostumerServiceImpl(UserRepository repository, CostumerMapper mapper){
        super(repository, mapper);
    }

    @Override
    public List<CostumerDTO> getAll() {
        return repository.findAll()
                .stream()
                .filter(costumer -> costumer.getRole().equals("costumer"))
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CostumerMiniDTO insert(CostumerForm form) throws ElementNotFoundException {

        User toInsert = mapper.toEntity(form);

        toInsert.setRole("costumer");

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);
    }

    @Override
    public CostumerDTO update(Integer id, CostumerUpdateForm form) throws ElementNotFoundException {

        User toUpdate = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        //Get all the variables of the updated form
        String name = form.getName();
        String username = form.getUsername();
        String password = form.getPassword();
        List<Integer> purchaseIDs = form.getOrdersID();

        if (name != null){
            toUpdate.setName(name);
        }

        if (username != null){
            toUpdate.setUsername(username);
        }

        if (password != null){
            toUpdate.setPassword(password);
        }

        if (purchaseIDs.size() > 0){

            toUpdate.setOrders(
                    purchaseIDs.stream()
                            .map(idPurchase -> purchaseRepository.findById(idPurchase).orElseThrow())
                            .collect(Collectors.toList())
            );
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
