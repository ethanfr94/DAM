package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.modelo.Grupo;
import org.example.modelo.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
        EntityManager em = emf.createEntityManager();

        int op;

        do{

            System.out.println("""
                    
                    1.Grupos
                    2.Usuarios que no han votado
                    3.Usuarios nacidos a partir de 1999
                    4.Grupos sin componentes cargados
                    5.Grupos sin compañia cargada
                    6.Grupos de Barcelona con primer disco antes de 2010
                    7.Numero de grupos de Madrid
                    0.Salir
                    """);

            op = Integer.parseInt(t.nextLine());

            switch(op){
                case 1->{
                    System.out.println("Grupos\n");
                    List<Grupo> grupos = em.createNamedQuery("Grupo.findAll", Grupo.class).getResultList();
                    for(Grupo g : grupos){
                        System.out.println(g.getNombre());
                    }
                }
                case 2->{
                    System.out.println("Usuarios que no han votado");
                    List<Usuario> usuarios = em.createNamedQuery("Usuario.sinVotos", Usuario.class).getResultList();
                    for(Usuario u : usuarios) {
                        System.out.println(u.getNombre());
                    }
                }
                case 3->{
                    System.out.println("Usuarios nacidos a partir de 1999");
                    TypedQuery <Usuario> query = em.createQuery("select u from Usuario u where u.fechanac >= :fecha", Usuario.class);
                    query.setParameter("fecha", LocalDate.of(1999, 1, 1));
                    List<Usuario> usuarios = query.getResultList();
                    for(Usuario u : usuarios) {
                        System.out.println(u.getNombre());
                    }
                }
                case 4->{
                    System.out.println("Grupos sin componentes cargados");
                    List<Grupo> grupos = em.createNamedQuery("Grupo.sinComponentes", Grupo.class).getResultList();
                    for(Grupo g : grupos) {
                        System.out.println(g.getNombre());
                    }
                }
                case 5->{
                    System.out.println("Grupos sin compañia cargada");
                    List<Grupo> grupos = em.createNamedQuery("Grupo.sinCompañia", Grupo.class).getResultList();
                    for(Grupo g : grupos) {
                        System.out.println(g.getNombre());
                    }
                }
                case 6->{
                    System.out.println("Grupos de Barcelona con primer disco antes de 2010");
                    List<Grupo> grupos = em.createNamedQuery("Grupo.Barcelona2010", Grupo.class).getResultList();
                    for(Grupo g : grupos) {
                        System.out.println(g.getNombre());
                    }
                }
                case 7->{
                    System.out.println("Numero de grupos de Madrid");
                    long numGrupos = em.createNamedQuery("Grupo.gruposDeMadrid", Long.class).getSingleResult();
                    System.out.println("Numero de grupos de Madrid: " + numGrupos);
                }
                case 0->{
                    System.out.println("Saliendo...");
                    System.exit(0);
                }
                default->{
                    System.out.println("Opcion no valida");
                }
            }

        }while(true);

    }
}