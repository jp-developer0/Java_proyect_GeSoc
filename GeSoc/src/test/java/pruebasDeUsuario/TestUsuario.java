package pruebasDeUsuario;

import operacionEgreso.*;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUsuario {

    private ByteArrayInputStream textoUsuario;
    private ByteArrayInputStream textoClave;
    private OperacionEgreso operacionEgreso;
    private MedioDePago paypal;
    private MedioDePago rapidcash;
    private List<Item> itemsA;
    private List<Item> itemsB;
    private Proveedor starbucks;
    private Proveedor bonafide;
    private DocumentoComercial documentoComercialA;
    private DocumentoComercial documentoComercialB;
    private Date fechaA;
    private Date fechaB;

    public TestUsuario() {
    }

    @Before
    public void init() {
        this.paypal = new MedioDePago();
        this.rapidcash = new MedioDePago();
        this.itemsA = new ArrayList();
        this.itemsB = new ArrayList();
        this.starbucks = new Proveedor("Starbucks", "STA", "Falsedad 1234");
        this.bonafide = new Proveedor("Bonafide", "BON", "Av. Perdida 552");
        this.documentoComercialA = new DocumentoComercial("factura", 1234, "adjunto", "transac");
        this.documentoComercialB = new DocumentoComercial("ticket", 6571, "teDeboUnAdjunto", "otras");
        this.fechaA = new Date(1590540149L);
        this.fechaB = new Date(1544440141L);
    }
}
