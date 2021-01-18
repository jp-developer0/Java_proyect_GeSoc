package pruebasHibernate;


import categoria.Categoria;
import categoria.Clasificador;
import categoria.Empresa;
import categoria.OSC;
import categoria.tipoDeEmpresa.TipoEmpresa;
import categoria.tipoDeEmpresa.actividad.Actividad;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import db.EntityManagerHelper;
import direccionPostal.Direccion;
import direccionPostal.DireccionPostal;
import domain.EntidadBase;
import domain.EntidadJuridica;
import operacionEgreso.*;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionIngreso.OperacionIngreso;
import org.junit.Before;
import org.junit.Test;
import usuario.Administrador;
import usuario.Usuario;
import validador.Validador;

import java.time.LocalDate;
import java.util.*;

public class TestInsertHEROKU {

    private OperacionIngreso oi;
    private OperacionEgreso operacionEgreso;
    private MedioDePago rapidcash;
    private Date fechaA;
    private Date fechaB;
    private List<Presupuesto> presupuestos;
    private CriteriosParaProveedores criterioProveedor;
    private List<Usuario> revisores;
    private Presupuesto presupuestoA;
    private Empresa ocBsAs;
    private Empresa ocNY;
    private Empresa ocMx;
    private Empresa surcos;
    private OSC andhres;
    private Usuario ale;
    private Usuario juli;
    private OperacionEgreso oe1;
    private List<Presupuesto> presupuestosOe1;
    private OperacionEgreso oe2;
    private List<Presupuesto> presupuestosOe2;
    private OperacionEgreso oe3;
    private List<Presupuesto> presupuestosOe3;
    private OperacionEgreso oe4;
    private List<Presupuesto> presupuestosOe4;
    private OperacionEgreso oe5;
    private List<Presupuesto> presupuestosOe5;
    private OperacionEgreso oe6;
    private List<Presupuesto> presupuestosOe6;
    private OperacionEgreso oe7;
    private List<Presupuesto> presupuestosOe7;
    private OperacionEgreso oe8;
    private List<Presupuesto> presupuestosOe8;
    private OperacionEgreso oe9;
    private List<Presupuesto> presupuestosOe9;
    private OperacionEgreso oe10;
    private List<Presupuesto> presupuestosOe10;
    private Presupuesto p1;
    private Presupuesto p2;
    private Presupuesto p3;
    private Presupuesto presupuesto1;
    private Presupuesto presupuesto2;
    private Presupuesto presupuesto3;
    private Presupuesto presupuesto4;
    private Presupuesto presupuesto5;
    private Presupuesto presupuesto6;
    private Presupuesto presupuesto7;
    private Presupuesto presupuesto8;
    private Presupuesto presupuesto9;
    private Presupuesto presupuesto10;
    private Presupuesto presupuesto11;
    private Presupuesto presupuesto12;
    private Presupuesto presupuesto13;
    private Presupuesto presupuesto14;
    private Presupuesto presupuesto15;
    private OperacionIngreso oi1;
    private OperacionIngreso oi2;
    private OperacionIngreso oi3;
    private OperacionIngreso oi4;
    private CategoriaEgreso fachada;
    private CategoriaEgreso humedad;
    private CategoriaEgreso serviciosGenerales;
    private CategoriaEgreso mueblesYutiles;
    private CategoriaEgreso coffeeBreak;
    private CategoriaEgreso electronicos;
    private CategoriaEgreso exterior;
    private CategoriaEgreso interior;
    private CategoriaEgreso luz;
    private CategoriaEgreso gas;
    private CategoriaEgreso necesarios;
    private CriterioEgreso mantenimiento;
    private CriterioEgreso lugarAplicacion;
    private CriterioEgreso causante;
    private CriterioEgreso gastosGenerales;
    private CriterioEgreso elementosOficina;
    private CriterioEgreso momentoUtilizacion;
    private CriterioEgreso tipoProducto;
    private CriterioEgreso servicios;
    private CriterioEgreso usoInterno;
    private DireccionPostal direccionPostalEAAFBA;
    private Direccion direccionEAAFBA;
    private List<EntidadBase> entidadesBaseEAAFBA;
    private List<OperacionEgreso> operacionesEgresoEAAFBA;
    private List<Usuario> usuariosEAAFBA;
    private List<Usuario> usuariosEAAFBA2;
    private List<Usuario> revisoresEAAFBA;
    private List<OperacionIngreso> ingresosEAAFBA;
    private EntidadJuridica EAAFBA;
    private DireccionPostal direccionPostalEAAFNY;
    private Direccion direccionEAAFNY;
    private List<EntidadBase> entidadesBaseEAAFNY;
    private List<OperacionEgreso> operacionesEgresoEAAFNY;
    private List<Usuario> usuariosEAAFNY;
    private EntidadJuridica EAAFNY;
    private DireccionPostal direccionPostalEAAFM;
    private Direccion direccionEAAFM;
    private List<EntidadBase> entidadesBaseEAAFM;
    private List<OperacionEgreso> operacionesEgresoEAAFM;
    private List<Usuario> usuariosEAAFM;
    private EntidadJuridica EAAFM;
    private DireccionPostal direccionPostalSurcos;
    private Direccion direccionSurcos;
    private List<EntidadBase> entidadesBaseSurcos;
    private List<OperacionEgreso> operacionesEgresoSurcos;
    private List<Usuario> usuariosSurcos;
    private List<Usuario> usuariosSurcos2;
    private List<Usuario> revisoresSurcos;
    private List<OperacionIngreso> ingresosSurcos;
    private EntidadJuridica Surcos;
    private EntidadBase andhes;
    private TipoEmpresa microConstruccion ;
    private TipoEmpresa microServicio ;
    private TipoEmpresa microComercio ;
    private TipoEmpresa microIndustria ;
    private TipoEmpresa microAgropecuario;

    private TipoEmpresa peqConstruccion ;
    private TipoEmpresa peqServicio;
    private TipoEmpresa peqComercio ;
    private TipoEmpresa peqIndustria;
    private TipoEmpresa peqAgropecuario;

    private TipoEmpresa med1Construccion ;
    private TipoEmpresa med1Servicio ;
    private TipoEmpresa med1Comercio ;
    private TipoEmpresa med1Industria ;
    private TipoEmpresa med1Agropecuario ;

    private TipoEmpresa med2Construccion ;
    private TipoEmpresa med2Servicio ;
    private TipoEmpresa med2Comercio ;
    private TipoEmpresa med2Industria ;
    private TipoEmpresa med2Agropecuario;
    private List<TipoEmpresa> tiposConstruccion;
    private List<TipoEmpresa> tiposServicio;

    private Actividad contruccion;
    private Actividad servicioAlojamiento;
    public TestInsertHEROKU() {
    }

    @Before
    public void init() {
        MenorValor menorValor= new MenorValor();
        //ORGANIZACIONES    -----
        Clasificador clas = Clasificador.getInstance();
        microConstruccion = new TipoEmpresa("Micro Construccion", 5900000,12);
        microServicio = new TipoEmpresa("Micro Servicio", 4600000,7);
        microComercio = new TipoEmpresa("Micro Comercio", 15800000,7);
        microIndustria = new TipoEmpresa("Micro Industria", 13400000,15);
        microAgropecuario = new TipoEmpresa("Micro Agropecuaria", 3800000,5);

        peqConstruccion = new TipoEmpresa("Pequeña Construccion", 37700000,45);
        peqServicio = new TipoEmpresa("Pequeña Servicio", 27600000,30);
        peqComercio = new TipoEmpresa("Pequeña Comercio", 95000000,35);
        peqIndustria = new TipoEmpresa("Pequeña Industria", 81400000,60);
        peqAgropecuario = new TipoEmpresa("Pequeña Agropecuaria", 23900000,10);

        med1Construccion = new TipoEmpresa("Mediana 1 Construccion", 301900000,200);
        med1Servicio = new TipoEmpresa("Mediana 1 Servicio", 230300000,165);
        med1Comercio = new TipoEmpresa("Mediana 1 Comercio", 798200000,125);
        med1Industria = new TipoEmpresa("Mediana 1 Industria", 661200000,235);
         med1Agropecuario = new TipoEmpresa("Mediana 1 Agropecuaria", 182400000,50);

       med2Construccion = new TipoEmpresa("Mediana 2 Construccion", 452800000,590);
        med2Servicio = new TipoEmpresa("Mediana 2 Servicio", 328900000,535);
         med2Comercio = new TipoEmpresa("Mediana 2 Comercio", 1140300000,345);
         med2Industria = new TipoEmpresa("Mediana 2 Industria", 966300000,655);
         med2Agropecuario = new TipoEmpresa("Mediana 2 Agropecuaria", 289300000,215);
         tiposConstruccion = new ArrayList<>();
        tiposConstruccion.add(microConstruccion);
        tiposConstruccion.add(peqConstruccion);
        tiposConstruccion.add(med1Construccion);
        tiposConstruccion.add(med2Construccion);
        tiposServicio = new ArrayList<>();
        tiposServicio.add(microServicio);
        tiposServicio.add(peqServicio);
        tiposServicio.add(med1Servicio);
        tiposServicio.add(med2Servicio);

        contruccion = new Actividad("Contruccion", tiposConstruccion);
        servicioAlojamiento = new Actividad("ServicioAlojamiento", tiposServicio);
        Clasificador clasificador = Clasificador.getInstance();
        ocBsAs = new Empresa(150, 600000000, contruccion);
        ocNY = new Empresa(580, 960000000, contruccion);
        ocMx = new Empresa(240, 643710000, contruccion);
        surcos = new Empresa(8, 8000000, servicioAlojamiento);
        andhres = new OSC();

        // EntidadJuridica EAAFBA
        direccionPostalEAAFBA= new DireccionPostal();
        direccionEAAFBA = new Direccion();

        direccionEAAFBA.setCalle("Av.Medrano");
        direccionEAAFBA.setAltura(951);
        direccionEAAFBA.setPisoYDpto("Casa");

        direccionPostalEAAFBA.setCiudad("Almagro/CABA");
        direccionPostalEAAFBA.setDireccion(direccionEAAFBA);
        direccionPostalEAAFBA.setProvincia("BA");
        direccionPostalEAAFBA.setPais("Argentina");

        entidadesBaseEAAFBA = new ArrayList<>();
        operacionesEgresoEAAFBA = new ArrayList<>();
        usuariosEAAFBA = new ArrayList<>();// creo la lista de usuarios para settear usuarios a esa entidad.
        ingresosEAAFBA = new ArrayList<>();

        EAAFBA= new EntidadJuridica("EAAF BA", "Oficina Central Buenos Aires", "30-15269857-2", direccionPostalEAAFBA, "", entidadesBaseEAAFBA, ocBsAs, operacionesEgresoEAAFBA, usuariosEAAFBA);

        Validador validador1=new Validador();
        EAAFBA.setValidador(validador1);

        // EntidadJuridica EAAFNY

        direccionPostalEAAFNY= new DireccionPostal();
        direccionEAAFNY = new Direccion();

        direccionEAAFNY.setCalle("Liberty Ave");
        direccionEAAFNY.setAltura(720);
        direccionEAAFNY.setPisoYDpto("Casa");

        direccionPostalEAAFNY.setCiudad("Brooklyn");
        direccionPostalEAAFNY.setDireccion(direccionEAAFNY);
        direccionPostalEAAFNY.setProvincia("Nueva York");
        direccionPostalEAAFNY.setPais("EEUU");

        entidadesBaseEAAFNY = new ArrayList<>();

        operacionesEgresoEAAFNY = new ArrayList<>();

        usuariosEAAFNY = new ArrayList<>();

        EAAFNY= new EntidadJuridica("EAAF NY", "Oficina Central Nueva York", "30-15789655-7", direccionPostalEAAFNY, "", entidadesBaseEAAFNY, ocNY, operacionesEgresoEAAFNY, usuariosEAAFNY);

        Validador validador2=new Validador();
        EAAFNY.setValidador(validador2);

        // EntidadJuridica EAAFM

         direccionPostalEAAFM= new DireccionPostal();
        direccionEAAFM = new Direccion();

        direccionEAAFM.setCalle("Roberto Gayol");
        direccionEAAFM.setAltura(55);
        direccionEAAFM.setPisoYDpto("Casa");

        direccionPostalEAAFM.setCiudad("Ciudad de Mexico");
        direccionPostalEAAFM.setDireccion(direccionEAAFM);
        direccionPostalEAAFM.setProvincia("Ciudad de Mexico");
        direccionPostalEAAFM.setPais("Mexico");

         entidadesBaseEAAFM = new ArrayList<>();

        operacionesEgresoEAAFM = new ArrayList<>();

        usuariosEAAFM = new ArrayList<>();

        EAAFM = new EntidadJuridica("EAAF M", "Oficina Central Mexico", "30-77896583-9", direccionPostalEAAFM, "", entidadesBaseEAAFM, ocMx, operacionesEgresoEAAFM, usuariosEAAFM);

        Validador validador3=new Validador();
        EAAFM.setValidador(validador3);

        // EntidadJuridica Surcos CS
        direccionPostalSurcos= new DireccionPostal();
        direccionSurcos = new Direccion();

        direccionSurcos.setCalle("Jeronimo Salguero");
        direccionSurcos.setAltura(2800);
        direccionSurcos.setPisoYDpto("Casa");

        direccionPostalSurcos.setCiudad("Palermo/CABA");
        direccionPostalSurcos.setDireccion(direccionSurcos);
        direccionPostalSurcos.setProvincia("Buenos Aires");
        direccionPostalSurcos.setPais("Argentina");

        entidadesBaseSurcos = new ArrayList<>();
        operacionesEgresoSurcos = new ArrayList<OperacionEgreso>();
        usuariosSurcos = new ArrayList<Usuario>();
        ingresosSurcos = new ArrayList<>();

        Surcos = new EntidadJuridica("Surcos CS", "Surcos", "30-25888897-8", direccionPostalSurcos, "", entidadesBaseSurcos, surcos, operacionesEgresoSurcos, usuariosSurcos);

        Validador validador4=new Validador();
        Surcos.setValidador(validador4);

        // EntidadJuridica entidadBase
        andhes = new EntidadBase("Andhes","Entidad base de Colectivo de Derechos de Infancia ");
        entidadesBaseSurcos.add(andhes);
        Surcos.setEntidadesBase(entidadesBaseSurcos);

                //EntidadBase entidadBase= new EntidadBase();
        //ORGANIZACIONES    ----- la empresa no tiene nombre !!!
//        Actividad contruccion = new Actividad("Contruccion", null);
//        Actividad servicioAlojamiento = new Actividad("ServicioAlojamiento", null);
//        this.ocBsAs = new Empresa(150, 600000000, contruccion, null);
//        this.ocNY = new Empresa(580, 960000000, contruccion, null);
//        this.ocMx = new Empresa(240, 643710000, contruccion, null);
//        this.surcos = new Empresa(8, 8000000, servicioAlojamiento, null);
//        this.andhres = new OSC();

        //USUARIOS
        this.ale = new Usuario();
        this.ale.setUsuario("aroco");
        this.ale.setPassword("*_aroco20!-?");

        ale.setEntidadJuridica(EAAFBA); // agregue esto Marcos
        usuariosEAAFBA2 = new ArrayList<>();
        usuariosEAAFBA2.add(ale);
        EAAFBA.setUsarios(usuariosEAAFBA2);

        this.juli = new Usuario();
        this.juli.setUsuario("jazul");
        this.juli.setPassword("!-*jazul_!?");
        juli.setEntidadJuridica(Surcos);
        usuariosSurcos2 = new ArrayList<>();
        usuariosSurcos2.add(juli);
        Surcos.setUsarios(usuariosSurcos2);

        // EGRESOS

        //Usuarios
        revisoresEAAFBA = new ArrayList<>();
        revisoresEAAFBA.add(ale);
        revisoresSurcos = new ArrayList<>();
        revisoresSurcos.add(juli);

        //Medios de pago
        MedioDePago tc1 = new MedioDePago();
        tc1.setMedio("Tarjeta de Crédito - 3 pagos s/i - N° tarjeta: 4509 9535 6623 3704 ");
        MedioDePago tc2 = new MedioDePago();
        tc2.setMedio("Tarjeta de Débito - N° tarjeta: 5031 7557 3453 0604 ");
        MedioDePago ef = new MedioDePago();
        ef.setMedio("Efectivo ");

        //PROVEEDORES
        Proveedor pintureriaSerrentino = new Proveedor("Pinturerías Serrentino", "PS", "1234");
        Proveedor pintureriasREX = new Proveedor("Pinturerías REX", "PR", "1234");
        Proveedor pintureriasSanJorge = new Proveedor("Pinturerías San Jorge", "PSJ", "1234");
        Proveedor edesur = new Proveedor("Edesur", "E", "1234");
        Proveedor metrogas = new Proveedor("Metrogas", "ME", "1234");
        Proveedor mitoas = new Proveedor("Mitoas SA", "M", "1234");
        Proveedor ingComSRL = new Proveedor("Ingeniería Comercial SRL", "ICS", "1234");
        Proveedor garbarino = new Proveedor("Garbarino", "G", "1234");
        Proveedor laCasaDelAudio = new Proveedor("La Casa del Audio", "LCDA", "1234");
        Proveedor coLaSRL = new Proveedor("Corralón Laprida SRL", "CLS", "1234");
        Proveedor corralonSanJuanSRL = new Proveedor("Corralón San Juan SRL", "CSJS", "1234");
        Proveedor telasZN = new Proveedor("Telas ZN", "TZN", "1234");

        // 1° Presupuesto
        this.presupuesto1 = new Presupuesto();
        Item i1p1 = new Item("PINTURA Z10 LATEX SUPERCUBRITIVO 20L",9900L,1);
        Item i2p1 = new Item("PINTURA LOXON FTES IMPERMEABILIZANTE 10L", 7200L,1);
        Item i3p1 = new Item("PINTURA BRIKOL PISOS NEGRO 4L", 4350L,1);
        List<Item> p1Items = new ArrayList<>();
        p1Items.add(i1p1);
        p1Items.add(i2p1);
        p1Items.add(i3p1);
        //this.presupuesto1 = new Presupuesto("presupuesto 1", null,p1Items,pintureriasREX);
        presupuesto1.setProveedor(pintureriasREX);
        presupuesto1.setItems(p1Items);
        presupuesto1.setDetalle("presupuesto 1");
        presupuesto1.setDocumentoComercial(null);
        presupuesto1.setEntidadJuridica(EAAFBA);
        presupuesto1.setFecha(LocalDate.of(2020, 2, 25));
        presupuesto1.setOperacionEgreso(oe1);
        presupuesto1.obtenerTotal();

        // 2° Presupuesto
        this.presupuesto2 = new Presupuesto();
        Item i1p2 = new Item("PINTURA Z10 LATEX SUPERCUBRITIVO 20L",9610L,1);;
        Item i2p2 = new Item("PINTURA LOXON FTES IMPERMEABILIZANTE 10L", 6590L,1);
        Item i3p2 = new Item("PINTURA BRIKOL PISOS NEGRO 4L", 4100L,1);
        List<Item> p2Items = new ArrayList<>();
        p2Items.add(i1p2);
        p2Items.add(i2p2);
        p2Items.add(i3p2);
        //this.presupuesto2 = new Presupuesto("presupuesto 2", null, p2Items, pintureriasSanJorge);
        presupuesto1.setProveedor(pintureriasSanJorge);
        presupuesto1.setItems(p2Items);
        presupuesto1.setDetalle("presupuesto 2");
        presupuesto1.setDocumentoComercial(null);
        presupuesto2.setEntidadJuridica(EAAFBA);
        presupuesto2.setFecha(LocalDate.of(2020, 2, 26));
        presupuesto2.setOperacionEgreso(oe1);
        presupuesto2.obtenerTotal();

        // presupuesto3
        Item i1p3 = new Item("PINTURA Z10 LATEX SUPERCUBRITIVO 20L",9625L,1);;
        Item i2p3 = new Item("PINTURA LOXON FTES IMPERMEABILIZANTE 10L", 6589L,1);
        Item i3p3 = new Item("PINTURA BRIKOL PISOS NEGRO 4L", 3738L,1);
        List<Item> p3Items = new ArrayList<>();
        p3Items.add(i1p3);
        p3Items.add(i2p3);
        p3Items.add(i3p3);
        this.presupuesto3 = new Presupuesto("presupuesto 3",null, p3Items, pintureriaSerrentino);
        presupuesto3.setEntidadJuridica(EAAFBA);
        presupuesto3.setFecha(LocalDate.of(2020, 2, 27));
        presupuesto3.setOperacionEgreso(oe1);
        presupuesto3.obtenerTotal();

        // presupuesto4
        Item i1p4 = new Item("TELEFONOS INALAMBRICOS MOTOROLA DUO BLANCO",8950L,2);
        List<Item> p4Items = new ArrayList<>();
        p4Items.add(i1p4);
        this.presupuesto4 = new Presupuesto("presupuesto 4",null, p4Items, laCasaDelAudio);
        presupuesto4.setEntidadJuridica(EAAFBA);
        presupuesto4.setFecha(LocalDate.of(2020, 9, 10));
        presupuesto4.setOperacionEgreso(oe5);
        presupuesto4.obtenerTotal();

        // presupuesto5
        Item i1p5 = new Item("TELEFONOS INALAMBRICOS MOTOROLA DUO BLANCO",8830L,2);
        List<Item> p5Items = new ArrayList<>();
        p5Items.add(i1p5);
        this.presupuesto5 = new Presupuesto("presupuesto 5", null, p5Items, garbarino);
        presupuesto5.setEntidadJuridica(EAAFBA);
        presupuesto5.setFecha(LocalDate.of(2020, 9, 11));
        presupuesto5.setOperacionEgreso(oe5);
        presupuesto5.obtenerTotal();

        // presupuesto6
        Item i1p6 = new Item("TELEFONOS INALAMBRICOS MOTOROLA DUO BLANCO",8500L,2);
        List<Item> p6Items = new ArrayList<>();
        p6Items.add(i1p6);
        this.presupuesto6 = new Presupuesto("presupuesto 6",null, p6Items, ingComSRL);
        presupuesto6.setEntidadJuridica(EAAFBA);
        presupuesto6.setFecha(LocalDate.of(2020, 9, 12));
        presupuesto6.setOperacionEgreso(oe5);
        presupuesto6.obtenerTotal();

        // presupuesto7
        Item i1p7 = new Item("CEMENTO LOMA NEGRA",715L,10); // Son 10
        Item i2p7 = new Item("ARENA FINA EN BOLSÓN X M30",3150L,5); // Son 5
        Item i3p7 = new Item("HIERRO ACINDAR",880L,4); // Son 4
        Item i4p7 = new Item("BLOQUE LADRILLO CEMENTO",235L,800); // Son 800
        List<Item> p7Items = new ArrayList<>();
        p7Items.add(i1p7);
        p7Items.add(i2p7);
        p7Items.add(i3p7);
        p7Items.add(i4p7);
        this.presupuesto7 = new Presupuesto("presupuesto 7", null, p7Items, corralonSanJuanSRL);
        presupuesto7.setEntidadJuridica(EAAFBA);
        presupuesto7.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto7.setOperacionEgreso(oe6);
        presupuesto7.obtenerTotal();

        // presupuesto8
        Item i1p8 = new Item("CEMENTO LOMA NEGRA",704L,10); // Son 10
        Item i2p8 = new Item("ARENA FINA EN BOLSÓN X M30",3100L,5); // Son 5
        Item i3p8 = new Item("HIERRO ACINDAR",891L,4); // Son 4
        Item i4p8 = new Item("BLOQUE LADRILLO CEMENTO",227L,800); // Son 800
        List<Item> p8Items = new ArrayList<>();
        p8Items.add(i1p8);
        p8Items.add(i2p8);
        p8Items.add(i3p8);
        p8Items.add(i4p8);
        this.presupuesto8 = new Presupuesto("presupuesto 8", null, p8Items, coLaSRL);
        presupuesto8.setEntidadJuridica(EAAFBA);
        presupuesto8.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto8.setOperacionEgreso(oe6);
        presupuesto8.obtenerTotal();

        // presupuesto9
        Item i1p9 = new Item("FACTURA SERVICIO DE LUZ PERIODO JUNIO 2020",2100L,1);
        List<Item> p9Items = new ArrayList<>();
        p9Items.add(i1p9);
        this.presupuesto9 = new Presupuesto("presupuesto 9", null, p9Items, edesur);
        presupuesto9.setEntidadJuridica(EAAFBA);
        presupuesto9.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto9.setOperacionEgreso(oe2);
        presupuesto9.obtenerTotal();

        // presupuesto10
        Item i1p10 = new Item("FACTURA SERVICIO DE LUZ PERIODO JUNIO 2020",3500L,1);
        List<Item> p10Items = new ArrayList<>();
        p10Items.add(i1p10);
        this.presupuesto10 = new Presupuesto("presupuesto 10", null, p10Items, metrogas);
        presupuesto10.setEntidadJuridica(EAAFBA);
        presupuesto10.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto10.setOperacionEgreso(oe3);
        presupuesto10.obtenerTotal();

        // presupuesto11
        Item i1p11 = new Item("PAVA ELECTRICA SMARTLIFE 1,5 LTS 1850W",4500L,3);
        Item i4p11 = new Item("CAFETERA SMARTLIFE 1095 ACERO INOX.",6300L,2);
        List<Item> p11Items = new ArrayList<>();
        p11Items.add(i1p11);
        p11Items.add(i4p11);
        this.presupuesto11 = new Presupuesto("presupuesto 11", null, p11Items, mitoas);
        presupuesto11.setEntidadJuridica(EAAFBA);
        presupuesto11.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto11.setOperacionEgreso(oe4);
        presupuesto11.obtenerTotal();

        // presupuesto12
        Item i1p12 = new Item("BLOQUE LADRILLO CEMENTO",250,800);
        List<Item> p12Items = new ArrayList<>();
        p12Items.add(i1p12);
        this.presupuesto12 = new Presupuesto("presupuesto 12", null, p12Items, coLaSRL);
        presupuesto12.setEntidadJuridica(EAAFBA);
        presupuesto12.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto12.setOperacionEgreso(oe7);
        presupuesto12.obtenerTotal();

        // presupuesto13
        Item i1p13 = new Item("FACTURA SERVICIO DE LUZ PERIODO JUNIO 2020",1100,1);
        List<Item> p13Items = new ArrayList<>();
        p13Items.add(i1p13);
        this.presupuesto13 = new Presupuesto("presupuesto 13", null, p13Items, edesur);
        presupuesto13.setEntidadJuridica(Surcos);
        presupuesto13.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto13.setOperacionEgreso(oe8);
        presupuesto13.obtenerTotal();

        // presupuesto14
        Item i1p14 = new Item("FACTURA SERVICIO DE GAS PERIODO JUNIO 2020",800L,1);
        List<Item> p14Items = new ArrayList<>();
        p14Items.add(i1p14);
        this.presupuesto14 = new Presupuesto("presupuesto 14", null, p14Items, metrogas);
        presupuesto14.setEntidadJuridica(Surcos);
        presupuesto14.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto14.setOperacionEgreso(oe9);
        presupuesto14.obtenerTotal();

        // presupuesto15
        Item i1p15 = new Item("CORTINAS BLACKOUT VINILICO 2 PAÑOS",4200L,5);
        List<Item> p15Items = new ArrayList<>();
        p15Items.add(i1p15);
        this.presupuesto15 = new Presupuesto("presupuesto 15", null, p15Items, telasZN);
        presupuesto15.setEntidadJuridica(Surcos);
        presupuesto15.setFecha(LocalDate.of(2020, 9, 15));
        presupuesto15.setOperacionEgreso(oe10);
        presupuesto15.obtenerTotal();

        //EGRESO 1
        this.fachada = new CategoriaEgreso();
        this.mantenimiento = new CriterioEgreso();
        mantenimiento.setDescripcion("Gastos de mantenimiento");
        fachada.setDescripcion("Fachada");
        mantenimiento.addCategoria(fachada);

        this.interior = new CategoriaEgreso();
        interior.setDescripcion("Interior");

        this.lugarAplicacion = new CriterioEgreso();
        lugarAplicacion.setDescripcion("Lugar de aplicacion");
        lugarAplicacion.setCriterioPadre(mantenimiento);
        lugarAplicacion.addCategoria(interior);

        this.humedad = new CategoriaEgreso();
        humedad.setDescripcion("humedad");
        this.causante = new CriterioEgreso();
        causante.setDescripcion("Causante");
        causante.addCategoria(humedad);

        List<CategoriaEgreso> categoriasEgreso1 = new ArrayList<CategoriaEgreso>();
        categoriasEgreso1.add(fachada);
        categoriasEgreso1.add(interior);
        categoriasEgreso1.add(humedad);

        this.oe1 = new OperacionEgreso();
        this.oe1.setFechaOperacion(LocalDate.of(2020, Calendar.MARCH, 10));
        this.oe1.setRequierePresupuestos(true);
        this.oe1.setCantidadPresupuestosRequeridos(3);
        this.oe1.setCategoriasEgreso(categoriasEgreso1);

        this.oe1.setPresupuestoElegido(presupuesto3);
        this.oe1.setMedioDePago(tc1);

        this.oe1.setTotal(presupuesto3.getTotal());

        this.oe1.agregarPresupuesto(presupuesto1);
        this.oe1.agregarPresupuesto(presupuesto2);
        this.oe1.agregarPresupuesto(presupuesto3);

        oe1.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe1.setEntidadJuridica(EAAFBA);
        oe1.setRevisores(revisoresEAAFBA);


        //EGRESO 2
        this.serviciosGenerales = new CategoriaEgreso();
        serviciosGenerales.setDescripcion("Servicios generales");
        this.gastosGenerales = new CriterioEgreso();
        gastosGenerales.setDescripcion("Gastos generales");
        gastosGenerales.addCategoria(serviciosGenerales);

        this.oe2 = new OperacionEgreso();
        this.oe2.setFechaOperacion(LocalDate.of(2020, 7, 8));
        this.oe2.setMedioDePago(ef);
        this.oe2.setRequierePresupuestos(false);
        this.oe2.addCategoria(serviciosGenerales);

        this.oe2.setPresupuestoElegido(presupuesto9);
        this.oe2.setTotal(presupuesto9.getTotal());


        this.oe2.agregarPresupuesto(presupuesto9);

        oe2.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe2.setEntidadJuridica(EAAFBA);
        oe2.setRevisores(revisoresEAAFBA);

        //3er Egreso
        this.oe3 = new OperacionEgreso();
        this.oe3.setFechaOperacion(LocalDate.of(2020, 7, 9));
        this.oe3.setMedioDePago(ef);
        this.oe3.setRequierePresupuestos(false);
        this.oe3.addCategoria(serviciosGenerales);

        this.oe3.setPresupuestoElegido(presupuesto10);
        this.oe3.setTotal(presupuesto10.getTotal());

        this.oe3.agregarPresupuesto(presupuesto10);

        oe3.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe3.setEntidadJuridica(EAAFBA);
        oe3.setRevisores(revisoresEAAFBA);

        //EGRESO 4
        //Muebles y últiles (Criterio "Elementos de oficina"), Coffe Break (Criterio "Momento de utilización")
        this.mueblesYutiles = new CategoriaEgreso();
        mueblesYutiles.setDescripcion("Muebles y utiles");
        this.elementosOficina = new CriterioEgreso();
        elementosOficina.addCategoria(mueblesYutiles);

        this.coffeeBreak = new CategoriaEgreso();
        coffeeBreak.setDescripcion("Coffee Break");
        this.momentoUtilizacion = new CriterioEgreso();
        momentoUtilizacion.setDescripcion("Momento de utilizacion");
        momentoUtilizacion.addCategoria(coffeeBreak);

        this.oe4 = new OperacionEgreso();
        this.oe4.setFechaOperacion(LocalDate.of(2020, 8, 3));

        this.oe4.setPresupuestoElegido(presupuesto11);
        this.oe4.setTotal(presupuesto11.getTotal());


        this.oe4.setRequierePresupuestos(false);
        this.oe4.setMedioDePago(tc2);
        this.oe4.addCategoria(mueblesYutiles);
        this.oe4.addCategoria(coffeeBreak);

        this.oe4.agregarPresupuesto(presupuesto11);

        oe4.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe4.setEntidadJuridica(EAAFBA);
        oe4.setRevisores(revisoresEAAFBA);

        //EGRESO 5
        this.electronicos = new CategoriaEgreso();
        electronicos.setDescripcion("Electronicos");
        this.tipoProducto = new CriterioEgreso();
        tipoProducto.setDescripcion("Tipo de producto");
        tipoProducto.addCategoria(electronicos);

        this.oe5=new OperacionEgreso();
        this.oe5.addCategoria(electronicos);
        this.oe5.setRequierePresupuestos(true);
        this.oe5.setCantidadPresupuestosRequeridos(3);

        this.oe5.setPresupuestoElegido(presupuesto6);
        this.oe5.setTotal(presupuesto6.getTotal());

        this.oe5.setFechaOperacion(LocalDate.of(2020,9,27));
        this.oe5.setMedioDePago(ef);

        this.oe5.agregarPresupuesto(presupuesto4);
        this.oe5.agregarPresupuesto(presupuesto5);
        this.oe5.agregarPresupuesto(presupuesto6);

        oe5.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe5.setEntidadJuridica(EAAFBA);
        oe5.setRevisores(revisoresEAAFBA);

        //EGRESO 6
        //Fachada (Criterio "Gastos de mantenimiento"), Exterior (Criterio "Lugar de aplicación", hijo de "Gastos de Mantenimiento"), Grande (Criterio "Tamaño del gasto")
        this.exterior = new CategoriaEgreso();
        exterior.setDescripcion("Exterior");
        lugarAplicacion.addCategoria(exterior);
        lugarAplicacion.setCriterioPadre(mantenimiento);

        CategoriaEgreso grande = new CategoriaEgreso();
        grande.setDescripcion("Grande");
        CriterioEgreso tamano = new CriterioEgreso();
        tamano.setDescripcion("Tamaño del gasto");
        tamano.addCategoria(grande);

        this.oe6=new OperacionEgreso();
        this.oe6.setFechaOperacion(LocalDate.of(2020,10,1));

        this.oe6.setPresupuestoElegido(presupuesto8);
        this.oe6.setTotal(presupuesto8.getTotal());

        this.oe6.setRequierePresupuestos(true);
        this.oe6.setCantidadPresupuestosRequeridos(4);
        this.oe6.addCategoria(fachada);
        this.oe6.addCategoria(exterior);
        this.oe6.addCategoria(grande);
        this.oe6.setMedioDePago(ef);

        oe6.agregarPresupuesto(presupuesto7);
        oe6.agregarPresupuesto(presupuesto8);

        oe6.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe6.setEntidadJuridica(EAAFBA);
        oe6.setRevisores(revisoresEAAFBA);

        //EGRESO 7
        this.oe7=new OperacionEgreso();
        this.oe7.setFechaOperacion(LocalDate.of(2020,10,5));
        this.oe7.setRequierePresupuestos(false);

        this.oe7.setPresupuestoElegido(presupuesto12);
        this.oe7.setTotal(presupuesto12.getTotal());

        this.oe7.addCategoria(fachada);
        this.oe7.addCategoria(exterior);
        this.oe7.addCategoria(grande);
        this.oe7.setMedioDePago(ef);

        oe7.agregarPresupuesto(presupuesto12);

        oe7.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe7.setEntidadJuridica(EAAFBA);
        oe7.setRevisores(revisoresEAAFBA);

        //EGRESO 8
        this.luz = new CategoriaEgreso();
        luz.setDescripcion("Servicios de luz");
        this.servicios = new CriterioEgreso();
        servicios.addCategoria(luz);
        servicios.setDescripcion("Servicios");
        this.oe8 = new OperacionEgreso();
        this.oe8.setFechaOperacion(LocalDate.of(2020,7,10));

        this.oe8.setPresupuestoElegido(presupuesto13);
        this.oe8.setTotal(presupuesto13.getTotal());

        this.oe8.setRequierePresupuestos(false);
        this.oe8.addCategoria(luz);
        this.oe8.setMedioDePago(ef);

        oe8.agregarPresupuesto(presupuesto13);

        oe8.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe8.setEntidadJuridica(Surcos);
        oe8.setRevisores(revisoresSurcos);

        //EGRESO 9
        this.gas = new CategoriaEgreso();
        gas.setDescripcion("Servicios de gas");
        servicios.addCategoria(gas);

        this.oe9 = new OperacionEgreso();
        this.oe9.setRequierePresupuestos(false);
        this.oe9.setFechaOperacion(LocalDate.of(2020,7,10));

        this.oe9.setPresupuestoElegido(presupuesto14);
        this.oe9.setTotal(presupuesto14.getTotal());

        this.oe9.addCategoria(gas);
        this.oe9.setMedioDePago(ef);

        oe9.agregarPresupuesto(presupuesto14);

        oe9.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe9.setEntidadJuridica(Surcos);
        oe9.setRevisores(revisoresSurcos);

        //EGRESO 10
        this.necesarios = new CategoriaEgreso();
        necesarios.setDescripcion("Necesarios");
        this.usoInterno = new CriterioEgreso();
        usoInterno.setDescripcion("Elementos de uso interno");
        usoInterno.addCategoria(necesarios);

        this.oe10=new OperacionEgreso();
        this.oe10.addCategoria(necesarios);
        this.oe10.setRequierePresupuestos(false);
        this.oe10.setFechaOperacion(LocalDate.of(2020,9,25));

        this.oe10.setPresupuestoElegido(presupuesto15);
        this.oe10.setTotal(presupuesto15.getTotal());

        this.oe10.setMedioDePago(ef);

        oe10.agregarPresupuesto(presupuesto15);

        oe10.setCriterioProveedor(menorValor);//seteo el criterio del proveedor, Marcos
        oe10.setEntidadJuridica(Surcos);
        oe10.setRevisores(revisoresSurcos);

        //  INGRESOS

        this.oi1 = new OperacionIngreso();
        this.oi1.setFechaOperacion(LocalDate.of(2020, 2,25 ));
        this.oi1.setFechaLimiteAceptabilidadEgresos(LocalDate.of(2020, 3,20 ));
        this.oi1.setDescripcion("Donación de terceros");
        this.oi1.setMontoTotal(20000);
        this.oi1.setSaldoRemanente(20000);
        oi1.setEntidadJuridica(EAAFBA);
        ingresosEAAFBA.add(oi1);

        this.oi2 = new OperacionIngreso();
        this.oi2.setFechaOperacion(LocalDate.of(2020, 5, 2));
        this.oi2.setFechaLimiteAceptabilidadEgresos(LocalDate.of(2020, 8, 3));
        this.oi2.setDescripcion("Donación de Rimoli SA");
        this.oi2.setMontoTotal(10000);
        this.oi2.setSaldoRemanente(10000);
        oi2.setEntidadJuridica(EAAFBA);
        ingresosEAAFBA.add(oi2);

        this.oi3 = new OperacionIngreso();
        this.oi3.setFechaOperacion(LocalDate.of(2020, 8, 3));
        this.oi3.setFechaLimiteAceptabilidadEgresos(LocalDate.of(2020, 10, 1));
        this.oi3.setDescripcion("Donación de Gran Imperio");
        this.oi3.setMontoTotal(980000);
        this.oi3.setSaldoRemanente(980000);
        oi3.setEntidadJuridica(EAAFBA);
        ingresosEAAFBA.add(oi3);

        this.oi4 = new OperacionIngreso();
        this.oi4.setFechaOperacion(LocalDate.of(2020, 5, 1));
        this.oi4.setFechaLimiteAceptabilidadEgresos(LocalDate.of(2020, 10, 1));
        this.oi4.setDescripcion("Donacion Gabino SRL");
        this.oi4.setMontoTotal(10000);
        this.oi4.setSaldoRemanente(10000);
        oi4.setEntidadJuridica(Surcos);
        ingresosSurcos.add(oi4);

        EAAFBA.setIngresos(ingresosEAAFBA);
        Surcos.setIngresos(ingresosSurcos);

        //Instancio las entidades con sus respectivos egresos y usuarios
        EAAFBA.registrarEgreso(oe1);
        EAAFBA.registrarEgreso(oe2);
        EAAFBA.registrarEgreso(oe3);
        EAAFBA.registrarEgreso(oe4);
        EAAFBA.registrarEgreso(oe5);
        EAAFBA.registrarEgreso(oe6);
        EAAFBA.registrarEgreso(oe7);

        Surcos.registrarEgreso(oe8);
        Surcos.registrarEgreso(oe9);
        Surcos.registrarEgreso(oe10);
        usuariosSurcos.add(juli);
    }

    @Test
    public void persistEgresoTest(){
        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.getEntityManager().persist(this.contruccion);
        EntityManagerHelper.getEntityManager().persist(this.servicioAlojamiento);

        EntityManagerHelper.getEntityManager().persist(this.microConstruccion);
        EntityManagerHelper.getEntityManager().persist(this.microServicio);
        EntityManagerHelper.getEntityManager().persist(this.peqConstruccion);
        EntityManagerHelper.getEntityManager().persist(this.peqServicio);
        EntityManagerHelper.getEntityManager().persist(this.med1Construccion);
        EntityManagerHelper.getEntityManager().persist(this.med2Construccion);
        EntityManagerHelper.getEntityManager().persist(this.med2Servicio);
        EntityManagerHelper.getEntityManager().persist(this.med2Servicio);

        EntityManagerHelper.getEntityManager().persist(this.fachada);
        EntityManagerHelper.getEntityManager().persist(this.interior);
        EntityManagerHelper.getEntityManager().persist(this.humedad);
        EntityManagerHelper.getEntityManager().persist(this.serviciosGenerales);
        EntityManagerHelper.getEntityManager().persist(this.mueblesYutiles);
        EntityManagerHelper.getEntityManager().persist(this.coffeeBreak);
        EntityManagerHelper.getEntityManager().persist(this.electronicos);
        EntityManagerHelper.getEntityManager().persist(this.exterior);
        EntityManagerHelper.getEntityManager().persist(this.luz);
        EntityManagerHelper.getEntityManager().persist(this.gas);
        EntityManagerHelper.getEntityManager().persist(this.necesarios);
        EntityManagerHelper.getEntityManager().persist(this.mantenimiento);
        EntityManagerHelper.getEntityManager().persist(this.lugarAplicacion);
        EntityManagerHelper.getEntityManager().persist(this.causante);
        EntityManagerHelper.getEntityManager().persist(this.gastosGenerales);
        EntityManagerHelper.getEntityManager().persist(this.elementosOficina);
        EntityManagerHelper.getEntityManager().persist(this.momentoUtilizacion);
        EntityManagerHelper.getEntityManager().persist(this.tipoProducto);
        EntityManagerHelper.getEntityManager().persist(this.servicios);
        EntityManagerHelper.getEntityManager().persist(this.usoInterno);
        EntityManagerHelper.getEntityManager().persist(this.ocBsAs);
        EntityManagerHelper.getEntityManager().persist(this.ocNY);
        EntityManagerHelper.getEntityManager().persist(this.ocMx);
        EntityManagerHelper.getEntityManager().persist(this.surcos);
        EntityManagerHelper.getEntityManager().persist(this.andhres);
        EntityManagerHelper.getEntityManager().persist(this.ale);
        EntityManagerHelper.getEntityManager().persist(this.juli);
        EntityManagerHelper.getEntityManager().persist(this.oe1);
        EntityManagerHelper.getEntityManager().persist(this.oe2);
        EntityManagerHelper.getEntityManager().persist(this.oe3);
        EntityManagerHelper.getEntityManager().persist(this.oe4);
        EntityManagerHelper.getEntityManager().persist(this.oe5);
        EntityManagerHelper.getEntityManager().persist(this.oe6);
        EntityManagerHelper.getEntityManager().persist(this.oe7);
        EntityManagerHelper.getEntityManager().persist(this.oe8);
        EntityManagerHelper.getEntityManager().persist(this.oe9);
        EntityManagerHelper.getEntityManager().persist(this.oe10);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto1);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto2);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto3);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto4);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto5);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto6);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto7);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto8);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto9);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto10);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto11);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto12);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto13);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto14);
        EntityManagerHelper.getEntityManager().persist(this.presupuesto15);
        EntityManagerHelper.getEntityManager().persist(this.oi1);
        EntityManagerHelper.getEntityManager().persist(this.oi2);
        EntityManagerHelper.getEntityManager().persist(this.oi3);
        EntityManagerHelper.getEntityManager().persist(this.oi4);
        EntityManagerHelper.getEntityManager().persist(this.direccionPostalEAAFBA);
        EntityManagerHelper.getEntityManager().persist(this.direccionEAAFBA);
//        EntityManagerHelper.getEntityManager().persist(this.entidadesBaseEAAFBA);
//        EntityManagerHelper.getEntityManager().persist(this.operacionesEgresoEAAFBA);
//        EntityManagerHelper.getEntityManager().persist(this.usuariosEAAFBA);
        EntityManagerHelper.getEntityManager().persist(this.EAAFBA);
        EntityManagerHelper.getEntityManager().persist(this.direccionPostalEAAFNY);
        EntityManagerHelper.getEntityManager().persist(this.direccionEAAFNY);
//        EntityManagerHelper.getEntityManager().persist(this.entidadesBaseEAAFNY);
//        EntityManagerHelper.getEntityManager().persist(this.operacionesEgresoEAAFNY);
//        EntityManagerHelper.getEntityManager().persist(this.usuariosEAAFNY);
        EntityManagerHelper.getEntityManager().persist(this.EAAFNY);
        EntityManagerHelper.getEntityManager().persist(this.direccionPostalEAAFM);
        EntityManagerHelper.getEntityManager().persist(this.direccionEAAFM);
//        EntityManagerHelper.getEntityManager().persist(this.entidadesBaseEAAFM);
//        EntityManagerHelper.getEntityManager().persist(this.operacionesEgresoEAAFM);
//        EntityManagerHelper.getEntityManager().persist(this.usuariosEAAFM);
        EntityManagerHelper.getEntityManager().persist(this.EAAFM);
        EntityManagerHelper.getEntityManager().persist(this.direccionPostalSurcos);
        EntityManagerHelper.getEntityManager().persist(this.direccionSurcos);
//        EntityManagerHelper.getEntityManager().persist(this.entidadesBaseSurcos);
//        EntityManagerHelper.getEntityManager().persist(this.operacionesEgresoSurcos);
//        EntityManagerHelper.getEntityManager().persist(this.usuariosSurcos);
        EntityManagerHelper.getEntityManager().persist(this.Surcos);
        EntityManagerHelper.getEntityManager().persist(this.andhes);

        EntityManagerHelper.commit();
    }
}



