package edu.courseproject.server.DAO;

import edu.courseproject.server.entity.Worker;

import java.util.List;

public interface WorkerDAO extends BaseDAO<Worker> {
    Worker findStatusByUserId(Long idUser);
   // boolean create(Worker worker,Long idregion);
    long findIdUserByIdWorker(Long idWorker);

    List<Worker> searchBySurname(String param);
}
