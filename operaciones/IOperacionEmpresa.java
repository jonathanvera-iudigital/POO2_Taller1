package operaciones;

import modelos.Empresa;

public interface IOperacionEmpresa {
    void    agregarEmpresa(Empresa e);
    void    listarEmpresas();
    Empresa buscarPorNit(String nit);
}
