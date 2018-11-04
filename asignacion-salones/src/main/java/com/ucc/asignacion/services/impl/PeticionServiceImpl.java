package com.ucc.asignacion.services.impl;

import com.ucc.asignacion.models.PeticionModel;
import com.ucc.asignacion.services.IPeticionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeticionServiceImpl implements IPeticionService {

    @Override
    public int numeroSalonesOcupados() {
        return 0;
    }

    @Override
    public List<PeticionModel> obtenerSolicitudes() {
        return new ArrayList<>();
    }
}
