package Model;

import DAO.GenericDAOI;
import java.util.ArrayList;
import java.util.List;

public class Staff implements GenericDAOI<Holiday> {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private double salaire;
    private Role role;
    private Poste poste;
    private List<Holiday> holidays;

    public enum Poste {
        INGENIEURE_ETUDE_ET_DEVELOPPEMENT,
        TEAM_LEADER,
        PILOTE
    }

    public enum Role {
        ADMIN,
        EMPLOYE
    }

    public Staff(String nom, String prenom, String email, String phone, double salaire, Role role, Poste poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.salaire = salaire;
        this.role = role;
        this.poste = poste;
        this.holidays = new ArrayList<>();
    }

    public Staff() {
        this.holidays = new ArrayList<>();
    }

    // Getters and setters for Staff fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    // Implementation of GenericDAOI methods
    @Override
    public void add(Holiday holiday) {
        holidays.add(holiday);
    }

    @Override
    public void update(Holiday holiday) {
        for (int i = 0; i < holidays.size(); i++) {
            if (holidays.get(i).getHolidayId() == holiday.getHolidayId()) {
                holidays.set(i, holiday);
                return;
            }
        }
    }

    @Override
    public Holiday findById(int id) {
        for (Holiday holiday : holidays) {
            if (holiday.getHolidayId() == id) {
                return holiday;
            }
        }
        return null;
    }

    @Override
    public List<Holiday> getAll() {
        return new ArrayList<>(holidays);
    }

    @Override
    public void delete(int id) {
        holidays.removeIf(holiday -> holiday.getHolidayId() == id);
    }
}