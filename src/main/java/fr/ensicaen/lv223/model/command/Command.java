package fr.ensicaen.lv223.model.command;

public interface Command {
    public void apply();
    public void unapply();
}
