package controller.dto;

import domain.Cliente;

public class ClienteDto {

    private Long id;

    private String nomeCompleto;

    private String cpf;

    private EnderecoDto endereco;

    private String telefone;

    private String email;

    public static Cliente paraDomain(ClienteDto dto){
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNomeCompleto(dto.getNomeCompleto());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(EnderecoDto.paraDomain(dto.getEndereco()));
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public static ClienteDto instanciarDeDomain(Cliente cliente){
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNomeCompleto(cliente.getNomeCompleto());
        dto.setCpf(cliente.getCpf());
        dto.setEndereco(EnderecoDto.instanciarDeDomain(cliente.getEndereco()));
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    public ClienteDto() {
    } //acho que nem precisa

    public ClienteDto(Long id, String nomeCompleto, String cpf, EnderecoDto endereco, String telefone, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
