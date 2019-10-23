package ru.lab6s1.data.dao;

import ru.lab6s1.data.mysql.ConnectionProperties;
import ru.lab6s1.data.mysql.MySqlConnector;
import ru.lab6s1.model.AuthorModel;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless(name = "DAOAuthor")
public class DAOAuthor implements DAO<AuthorModel>, Serializable {

    private static final Logger log = Logger.getLogger(DAOAuthor.class.getName());
    private MySqlConnector sqlConnector;
    public DAOAuthor() {
        log.info("IN DAOAuthor Constructor run");
        this.sqlConnector = new MySqlConnector(
                ConnectionProperties.createMySqlProperties("labjava", "root", "root"));
    }
    @PostConstruct
    public void PostConstruct(){
        //Действия после создания bean объекта
        /**инициализация полей DAO-класса из конструктора в метод
         обработки событий ЖЦ @PostConstruct*/
        log.info("IN DAOAuthor Constructor run");
    }
    /**
     * Вывести список всех авторов
     * @return
     */
    @Override
    public List<AuthorModel> selectList(){
        log.info("IN DAOAuthor selectList run");
        List<AuthorModel> list = new ArrayList<>();
        String query = "SELECT * FROM author";
        try {
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AuthorModel am = new AuthorModel();
                am.setId(rs.getInt("id_Author"));
                am.setSurname(rs.getString("Surname"));
                am.setName(rs.getString("Name"));
                am.setPatronymic(rs.getString("Patronymic"));
                am.setBirthDate(rs.getDate("Date_of_Birth"));
                am.setCity(rs.getString("City"));
                list.add(am);
        }
        log.info("IN DAOAuthor selectList complete");
        rs.close();
        ps.close();
        return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * Вывести информацию об авторе
     * @param id
     * @return
     */
    @Override
    public AuthorModel selectID(int id) {
        log.info("IN DAOAuthor selectID run");
        try{ AuthorModel am = new AuthorModel();
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(
                    "SELECT * FROM author where `id_Author` = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                am = new AuthorModel(rs.getInt("id_Author"), rs.getString("Surname"),
                        rs.getString("Name"), rs.getString("Patronymic"),
                        rs.getDate("Date_of_Birth"), rs.getString("City"));
            }
            log.info("IN DAOAuthor selectID complete");
            rs.close();
            ps.close();
            return am;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Добавить автора
     * @param am
     */
    @Override
    public void insert(AuthorModel am){
        String query = "INSERT INTO author (Surname, Name, Patronymic, Date_of_Birth, City)" +
                "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(query);
        ps.setString(1, am.getSurname());
        ps.setString(2, am.getName());
        ps.setString(3, am.getPatronymic());
        ps.setDate(4, new Date(am.getBirthDate().getTime()+24 * 3600 * 1000));
        ps.setString(5, am.getCity());
        ps.executeUpdate();
        ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Обновить автора
     * @param am
     */
    @Override
    public void update(AuthorModel am){
        String query = "UPDATE author SET Surname=?, Name=?, Patronymic=?, Date_of_Birth=?, " +
                "City=? WHERE id_Author=?";
        try{
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(query);
        ps.setString(1, am.getSurname());
        ps.setString(2, am.getName());
        ps.setString(3, am.getPatronymic());
        ps.setDate(4, new Date(am.getBirthDate().getTime()+24 * 3600 * 1000));
        ps.setString(5, am.getCity());
        ps.setInt(6, am.getId());
        ps.executeUpdate();
        ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Удалить автора
     * @param id
     * @return
     */
    @Override
    public void delete(int id){
        String query = "DELETE FROM author WHERE id_Author = ?";
        try{
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Установить авто инкремент
     * @param am
     * @return
     */
    public void autoIncrement(AuthorModel am){
        try{
            PreparedStatement ps = sqlConnector.getConnection().prepareStatement(
                    "ALTER TABLE author AUTO_INCREMENT=?");
            ps.setInt(1, am.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
