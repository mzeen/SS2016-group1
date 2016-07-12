package gse1.buergerbusserver.linemanagement.dataaccess.impl.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import gse1.buergerbusserver.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import gse1.buergerbusserver.linemanagement.dataaccess.api.CustomStopEntity;
import gse1.buergerbusserver.linemanagement.dataaccess.api.dao.CustomStopDao;

/**
 * Implementation of {@link CustomStopDao}.
 *
 * @author Sriramk88
 *
 */

@Named
public class CustomStopDaoImpl extends ApplicationMasterDataDaoImpl<CustomStopEntity> implements CustomStopDao {

  /**
   * the constructor
   */
  public CustomStopDaoImpl() {

    super();

  }

  /**
   *
   */

  @Override
  protected Class<CustomStopEntity> getEntityClass() {

    return CustomStopEntity.class;
  }

  @Override
  public List<CustomStopEntity> getCustomStopStatus(Long requestId, String deviceId) {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CustomStopEntity> cq = cb.createQuery(CustomStopEntity.class);
      Root<CustomStopEntity> ro = cq.from(CustomStopEntity.class);

      cq.select(ro);
      cq.where(cb.and(cb.equal(ro.get("id"), requestId), cb.equal(ro.get("deviceId"), deviceId)));

      List<CustomStopEntity> result = em.createQuery(cq).getResultList();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      List<CustomStopEntity> result = null;
      return result;
    }
  }

  @Override
  public List<CustomStopEntity> getCustomStopDevice(String deviceId) {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CustomStopEntity> cq = cb.createQuery(CustomStopEntity.class);
      Root<CustomStopEntity> ro = cq.from(CustomStopEntity.class);

      cq.select(ro);
      cq.where(cb.equal(ro.get("deviceId"), deviceId));

      List<CustomStopEntity> result = em.createQuery(cq).getResultList();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      List<CustomStopEntity> result = null;
      return result;
    }
  }

  @Override
  public List<CustomStopEntity> getCustomStopLine(Long lineId) {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CustomStopEntity> cq = cb.createQuery(CustomStopEntity.class);
      Root<CustomStopEntity> ro = cq.from(CustomStopEntity.class);

      Calendar cal = Calendar.getInstance();
      Date currDate = cal.getTime();
      List<Integer> statusValues = new ArrayList<>();
      statusValues.add(1);
      statusValues.add(3);

      cq.select(ro);
      cq.where(
          cb.and(cb.equal(ro.get("lineId"), lineId), cb.greaterThanOrEqualTo(ro.<Date> get("pickUpTime"), currDate),
              cb.or(cb.equal(ro.get("status"), 1), cb.equal(ro.get("status"), 3))));

      // cq.where(cb.equal(ro.get("lineId"), lineId));

      List<CustomStopEntity> result = em.createQuery(cq).getResultList();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      List<CustomStopEntity> result = null;
      return result;
    }
  }

  @Override
  public List<CustomStopEntity> getCustomStopRequests(Long requestId) {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<CustomStopEntity> cq = cb.createQuery(CustomStopEntity.class);
      Root<CustomStopEntity> ro = cq.from(CustomStopEntity.class);

      cq.select(ro);
      cq.where(cb.equal(ro.get("id"), requestId));

      List<CustomStopEntity> result = em.createQuery(cq).getResultList();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      List<CustomStopEntity> result = null;
      return result;
    }
  }

  @Override
  public void updateCustomStopStatus(Long requestId, int status) {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaUpdate<CustomStopEntity> cu = cb.createCriteriaUpdate((CustomStopEntity.class));
      Root<CustomStopEntity> ro = cu.from(CustomStopEntity.class);

      cu.set(ro.get("status"), status);
      cu.where(cb.equal(ro.get("id"), requestId));

      em.createQuery(cu).executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public Long newCustomStopTransaction(Long lineId, Date pickUpTime, double lat, double lon, int numberOfPersons,
      String deviceId, String userName, String userAddress, String userAssistance) {

    // Session session = HibernateUtil.getSessionFactory().openSession();
    // buildSessionFactory
    // session.beginTransaction();

    Date date = new Date();
    Date currTimeStamp = new Timestamp(date.getTime());

    Configuration config = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistry serviceRegistry =
        new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
    Session session = sessionFactory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();

      CustomStopEntity cse = new CustomStopEntity();

      cse.setDeviceId(deviceId);
      cse.setLat(lat);
      cse.setLon(lon);
      cse.setLineId(lineId);
      cse.setPickUpTime(pickUpTime);
      cse.setNumberOfPersons(numberOfPersons);
      cse.setStatus(5);
      cse.setUserName(userName);
      cse.setUserAddress(userAddress);
      cse.setUserAssistance(userAssistance);
      cse.setTimeStamp(currTimeStamp);
      // Long requestId = (Long) session.save(cse);

      Long requestId = cse.getId();
      System.out.println("requestId: " + requestId);
      // session.save(cse);
      Serializable reqID = session.save(cse);
      Long req = (Long) reqID;
      long requestID = req.longValue();

      System.out.println("requestID: " + requestID);
      tx.commit();

      return requestId;
    } catch (HibernateException e) {
      if (tx != null)
        tx.rollback();
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      session.close();
    }
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public Date lastUpdate() {

    try {
      EntityManager em = getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Date> cq = cb.createQuery(Date.class);

      Root ro = cq.from(CustomStopEntity.class);
      cq.select(cb.max(ro.<Date> get("TIMESTAMP")));

      // Root<CustomStopEntity> ro = cq.from(CustomStopEntity.class);
      // cq.select(cb.greatest(ro.get(CustomStopEntity_."TIMESTAMP")));

      return em.createQuery(cq).getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}