package com.example.chatbot.Shared.Validation;

import java.util.ArrayList;
import java.util.List;

public class ValidateCampo {
    private ValidateModel validateModel;
    private List<ValidateModel> listError = new ArrayList<>();

    public ValidateCampo() {
        this.validateModel = new ValidateModel();
    }

    public void inserErrorString(String type, String data) {
        this.cleanListError();
        if (data == null || data.isEmpty()) {
            this.validateModel.setType(type);
            this.validateModel.setMessage("Este campo no puede estar vacío");
            this.listError.add(this.validateModel);
            return;
        }
        if (data.length() < 4 || data.length() > 100) {
            this.validateModel.setType(type);
            this.validateModel.setMessage("Este campo debe tener un minimno de 4 a 100 caracteres");
            this.listError.add(this.validateModel);
            return;
        }
    }

    public void insertErrorInt(String type, Integer data) {
        this.cleanListError();
        if (data == null || data < 0) {
            this.validateModel.setType(type);
            this.validateModel.setMessage("Este campo no puede estar vacío o ser un 0");
            this.listError.add(this.validateModel);
        }
    }

    private void cleanListError() {
        this.listError.clear();
    }

    public List<ValidateModel> getListError() {
        return this.listError;
    }
}
