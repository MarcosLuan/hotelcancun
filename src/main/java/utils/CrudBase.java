package utils;

import java.util.Optional;

public interface CrudBase<T> {
    Optional<T> buscarPorId(Long id);

    void excluir(T entity);

    Optional<T> salvar(T entity);
}
