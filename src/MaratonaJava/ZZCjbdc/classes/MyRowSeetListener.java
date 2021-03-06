package MaratonaJava.ZZCjbdc.classes;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

public class MyRowSeetListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("O comando execute foi executado");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Linha foi atualizada, inserida ou deletada");
        if(event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor moveu");
    }
}
