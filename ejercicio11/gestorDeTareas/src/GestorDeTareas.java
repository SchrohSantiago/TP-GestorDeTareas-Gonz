import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;

public class GestorDeTareas extends Application {
    private ListView<Tarea> listaDeTareas;
    private List<Tarea> tareas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tareas = new ArrayList<>();
        listaDeTareas = new ListView<>();

        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre de la tarea");
        TextArea descripcionArea = new TextArea();
        descripcionArea.setPromptText("Descripción de la tarea");

        Button agregarButton = new Button("Agregar Tarea");
        agregarButton.setOnAction(e -> agregarTarea(nombreField, descripcionArea));

        Button editarButton = new Button("Editar Tarea");
        editarButton.setOnAction(e -> editarTarea(nombreField, descripcionArea));

        Button eliminarButton = new Button("Eliminar Tarea");
        eliminarButton.setOnAction(e -> eliminarTarea());

        Button marcarCompletadaButton = new Button("Marcar como Completada");
        marcarCompletadaButton.setOnAction(e -> marcarComoCompletada());

        HBox inputBox = new HBox(10, nombreField, descripcionArea, agregarButton, editarButton, eliminarButton, marcarCompletadaButton);
        VBox root = new VBox(10, inputBox, listaDeTareas);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarTarea(TextField nombreField, TextArea descripcionArea) {
        String nombre = nombreField.getText();
        String descripcion = descripcionArea.getText();
        if (!nombre.isEmpty() && !descripcion.isEmpty()) {
            Tarea nuevaTarea = new Tarea(nombre, descripcion);
            tareas.add(nuevaTarea);
            actualizarListaDeTareas();
            nombreField.clear();
            descripcionArea.clear();
        }
    }

    private void editarTarea(TextField nombreField, TextArea descripcionArea) {
        Tarea tareaSeleccionada = listaDeTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            String nombre = nombreField.getText();
            String descripcion = descripcionArea.getText();
            if (!nombre.isEmpty() && !descripcion.isEmpty()) {
                tareaSeleccionada.setNombre(nombre);
                tareaSeleccionada.setDescripcion(descripcion);
                actualizarListaDeTareas();
                nombreField.clear();
                descripcionArea.clear();
            }
        }
    }

    private void eliminarTarea() {
        Tarea tareaSeleccionada = listaDeTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareas.remove(tareaSeleccionada);
            actualizarListaDeTareas();
        }
    }

    private void marcarComoCompletada() {
        Tarea tareaSeleccionada = listaDeTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareaSeleccionada.setCompletada(true);
            actualizarListaDeTareas();
        }
    }

    private void actualizarListaDeTareas() {
        listaDeTareas.getItems().setAll(tareas);
    }
}