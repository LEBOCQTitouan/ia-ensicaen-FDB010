package fr.ensicaen.lv223.presenter;

public abstract class ViewEffector {
    protected final ViewModificator view;

    public ViewEffector(ViewModificator view) {
        this.view = view;
    }
}
