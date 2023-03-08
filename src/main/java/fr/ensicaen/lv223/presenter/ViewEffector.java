package fr.ensicaen.lv223.presenter;

public abstract class ViewEffector {
    protected ViewModificator view;

    public ViewEffector(ViewModificator view) {
        this.view = view;
    }

    public void setView(ViewModificator view) {
        this.view = view;
    }
}
