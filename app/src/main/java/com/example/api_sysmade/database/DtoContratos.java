package com.example.api_sysmade.database;

public class DtoContratos {
    private int id;
    private String nome, cpf, email, empresa, cnpj, tel_com, tipo_sys, dev_resp, data_ini, data_fim;

    public DtoContratos() {

    }

    public DtoContratos(String nome, String cpf, String email, String empresa, String cnpj, String tel_com, String tipo_sys,
      String dev_resp, String data_ini, String data_fim) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.empresa = empresa;
        this.cnpj = cnpj;
        this.tel_com = tel_com;
        this.tipo_sys = tipo_sys;
        this.dev_resp = dev_resp;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTel_com() {
        return tel_com;
    }
    public void setTel_com(String tel_com) {
        this.tel_com = tel_com;
    }

    public String getTipo_sys() {
        return tipo_sys;
    }
    public void setTipo_sys(String tipo_sys) {
        this.tipo_sys = tipo_sys;
    }

    public String getDev_resp() {
        return dev_resp;
    }
    public void setDev_resp(String dev_resp) {
        this.dev_resp = dev_resp;
    }

    public String getData_ini() {
        return data_ini;
    }
    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public String getData_fim() {
        return data_fim;
    }
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }


    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", empresa='" + empresa + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tel_com='" + tel_com + '\'' +
                ", tipo_sys='" + tipo_sys + '\'' +
                ", dev_resp='" + dev_resp + '\'' +
                ", data_ini='" + data_ini + '\'' +
                ", data_fim='" + data_fim;

    }
}