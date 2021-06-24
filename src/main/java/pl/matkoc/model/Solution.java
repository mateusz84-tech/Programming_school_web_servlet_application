package pl.matkoc.model;

import java.sql.Timestamp;

public class Solution {

    private int id_solution;
    private Timestamp created;
    private Timestamp updated;
    private String description;
    private int exercise_id;
    private int user_id;

    public Solution() {};

    public Solution(Timestamp created, Timestamp updated, String description, int exercise_id, int user_id) {
        if(created == null){
            throw new NullPointerException("Data utworzenia nie może być pusta.");
        }
        if(updated == null){
            throw new NullPointerException("Data edycji nie może być pusta.");
        }
        if(description.isEmpty() || description.isBlank()){
            throw new IllegalArgumentException("Opis nie może być pusty.");
        }
        if(exercise_id < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        if(user_id < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise_id = exercise_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id_solution;
    }

    public void setId(int id_solution) {
        if(id_solution < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        this.id_solution = id_solution;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        if(created == null){
            throw new NullPointerException("Data nie może być pusta.");
        }
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        if(updated == null){
            throw new NullPointerException("Data nie może być pusta.");
        }
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.isBlank() || description.isEmpty()){
            throw new IllegalArgumentException("Opis nie możę być pusty.");
        }
        this.description = description;
    }

    public int getExerciseId() {
        return exercise_id;
    }

    public void setExerciseId(int exerciseId) {
        if(exerciseId < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        this.exercise_id = exerciseId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        if(userId < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return String.format("%s: %d %s: %s %s: %s %s: %s %s: %d %s: %d%n","ID"
                ,getId(),"Utoworzono",getCreated(),
                "Edytowano",getUpdated(),"Opis",getDescription(),
                "Użytkownik nr",getUserId(),"Ćwiczenie nr",getExerciseId());
    }
}
