package com.example.focourseAS.Repository;

import com.example.focourseAS.Entity.Appliance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance,Long> {

//    @Query(
//            value = "select * from tb_student s where s.id = :id",
//            nativeQuery = true
//    )
//    public Student getStudentByIdNative(@Param("id") long id);


    @Query(
            value = "select * from appliance s where date_entered BETWEEN DATE '2023-03-01' AND '2023-03-31'",
            nativeQuery = true

    )
    public List<Appliance> filterByFEB();

    @Query(
            value = "select * from appliance s where date_entered BETWEEN :date AND :anotherDate",
            nativeQuery = true
    )
    public List<Appliance> filterByDate(@Param("date") LocalDate date, @Param("anotherDate") LocalDate anotherDate);

//    @Query(
//            value ="select * from appliance s where category = :name AND id = :id AND date = :date",
//            nativeQuery = true
//    )
//    public List<Appliance> filteerList(List<String> list);

//    //  value = "SELECT * FROM appliance s WHERE (:name IS NULL OR name = :name) AND (:category IS NULL OR category = :category) AND (:identity IS NULL OR identity = :identity) AND (:date IS NULL OR date >= :date) AND (:nu IS NULL OR date <= :nu)",
//    @Query(
//            value = "SELECT * FROM appliance s WHERE (:first IS NULL OR category = :first) " +
//                    "AND (:second IS null OR category = :second) " +
//                    "AND (:third IS null OR category = :third) " +
//                    "AND date_entered BETWEEN :date AND :anotherDate ",
//            nativeQuery = true
//    )

    @Query(
            value = "SELECT * FROM appliance s \n" +
                    "WHERE (:first IS NULL OR category = :first)\n" +
                    "  AND (:second IS NULL OR category = :second)\n" +
                    "  AND (:third IS NULL OR category = :third)\n" +
                    "  AND date_entered BETWEEN :date AND :anotherDate\n",
            nativeQuery = true
    )
    public Page<Appliance> filterList(@Param("first") String first, @Param("second") String second,
                                      @Param("third") String third,
                                      @Param("date") LocalDate date, @Param("anotherDate") LocalDate anotherDate,
                                      Pageable pageable);

}
