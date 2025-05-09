/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.IstorijaStanjaZaliha;
import domain.JedinicaMere;
import domain.Magacin;
import domain.Pakovanje;
import domain.PoslovniPartnerView;
import domain.Proizvod;
import domain.Radnik;
import domain.StavkaZapisnikaOPrijemuMaterijala;
import domain.Trebovanje;
import domain.ZapisnikGRP;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.GET_ALL_JM:
                    response.setData(ServerController.getInstance().getAllJediniceMere());
                    break;
                case Operation.GET_ALL_PROIZVOD:
                    response.setData(ServerController.getInstance().getAllProizvod());
                    break;
                case Operation.UPDATE_PROIZVOD:
                    ServerController.getInstance().updateProizvod((Proizvod) request.getData());
                    break;
                case Operation.ADD_PROIZVOD:
                    ServerController.getInstance().addProizvod((Proizvod) request.getData());
                    break;
                case Operation.DELETE_PROIZVOD:
                    ServerController.getInstance().deleteProizvod((Proizvod) request.getData());
                    break;
                case Operation.GET_ALL_ISTORIJA:
                    response.setData(ServerController.getInstance().getAllIstorija());
                    break;
                case Operation.GET_ALL_MAGACIN:
                    response.setData(ServerController.getInstance().getAllMagacin());
                    break;
                case Operation.ADD_ISTORIJA:
                    ServerController.getInstance().addIstorija((IstorijaStanjaZaliha) request.getData());
                    break;
                case Operation.UPDATE_ISTORIJA:
                    ServerController.getInstance().updateIstorija((IstorijaStanjaZaliha) request.getData());
                    break;
                case Operation.DELETE_ISTORIJA:
                    ServerController.getInstance().deleteIstorija((IstorijaStanjaZaliha) request.getData());
                    break;
                case Operation.GET_ALL_STAVKAZOPM:
                    response.setData(ServerController.getInstance().getAllStavkaZOPM());
                    break;
               case Operation.UPDATE_STAVKAZOPM:
                    ServerController.getInstance().updateStavkaZOPM((StavkaZapisnikaOPrijemuMaterijala) request.getData());
                    break;
                case Operation.GET_ALL_ZOPM:
                    response.setData(ServerController.getInstance().getAllZOPM());
                    break;
                case Operation.ADD_STAVKAZOPM:
                    ServerController.getInstance().addStavkaZOPM((StavkaZapisnikaOPrijemuMaterijala) request.getData());
                    break;
                case Operation.DELETE_STAVKAZOPM:
                    ServerController.getInstance().deleteStavkaZOPM((StavkaZapisnikaOPrijemuMaterijala) request.getData());
                    break;
                case Operation.GET_ALL_PARTNERVIEW:
                    response.setData(ServerController.getInstance().getAllPoslovniPartnerView());
                    break;
                case Operation.GET_ALL_PARTNER:
                    response.setData(ServerController.getInstance().getAllPoslovniPartner());
                    break;
                case Operation.GET_ALL_PARTNERDETALJI:
                    response.setData(ServerController.getInstance().getAllPoslovniPartnerDetalji());
                    break;
                case Operation.GET_ALL_MESTO:
                    response.setData(ServerController.getInstance().getAllMesto());
                    break;
                case Operation.ADD_PARTNER:
                    ServerController.getInstance().addPartner((PoslovniPartnerView) request.getData());
                    break;
                case Operation.UPDATE_PARTNER:
                    ServerController.getInstance().updatePartner((PoslovniPartnerView) request.getData());
                    break;
                case Operation.DELETE_PARTNER:
                    ServerController.getInstance().deletePartner((PoslovniPartnerView) request.getData());
                    break;
                case Operation.GET_ALL_RADNIK:
                    response.setData(ServerController.getInstance().getAllRadnik());
                    break;
                case Operation.UPDATE_RADNIK:
                    ServerController.getInstance().updateRadnik((Radnik) request.getData());
                    break;
                case Operation.ADD_RADNIK:
                    ServerController.getInstance().addRadnik((Radnik) request.getData());
                    break;
                case Operation.DELETE_RADNIK:
                    ServerController.getInstance().deleteRadnik((Radnik) request.getData());
                    break;
                case Operation.GET_ALL_TREBOVANJE:
                    response.setData(ServerController.getInstance().getAllTrebovanje());
                    break;
                case Operation.GET_ALL_ZAPISNIKGR1:
                    response.setData(ServerController.getInstance().getAllZapisnikGR1());
                    break;
                case Operation.GET_ALL_ZAPISNIKGR2:
                    response.setData(ServerController.getInstance().getAllZapisnikGR2());
                    break;
                case Operation.GET_ALL_ZAPISNIKGR3:
                    response.setData(ServerController.getInstance().getAllZapisnikGR3());
                    break;
                case Operation.GET_ALL_ZAPISNIKGR:
                    response.setData(ServerController.getInstance().getAllZapisnikGR());
                    break;
                case Operation.GET_ALL_ORGJED:
                    response.setData(ServerController.getInstance().getAllOrgJed());
                    break;
                case Operation.ADD_ZAPISNIKGR:
                    ServerController.getInstance().addZapisnikGR((ZapisnikGRP) request.getData());
                    break;
                case Operation.UPDATE_ZAPISNIKGR:
                    ServerController.getInstance().updateZapisnikGR((ZapisnikGRP) request.getData());
                    break;
                case Operation.DELETE_ZAPISNIKGR:
                    ServerController.getInstance().deleteZapisnikGR((ZapisnikGRP) request.getData());
                    break;
                case Operation.ADD_TREBOVANJE:
                    ServerController.getInstance().addTrebovanje((Trebovanje) request.getData());
                    break;
                case Operation.UPDATE_TREBOVANJE:
                    ServerController.getInstance().updateTrebovanje((Trebovanje) request.getData());
                    break;
                case Operation.DELETE_TREBOVANJE:
                    ServerController.getInstance().deleteTrebovanje((Trebovanje) request.getData());
                    break;
                case Operation.GET_ALL_NAMENA:
                    response.setData(ServerController.getInstance().getAllNamena());
                    break;
                case Operation.ADD_MAGACIN:
                    ServerController.getInstance().addMagacin((Magacin) request.getData());
                    break;
                case Operation.UPDATE_MAGACIN:
                    ServerController.getInstance().updateMagacin((Magacin) request.getData());
                    break;
                case Operation.DELETE_MAGACIN:
                    ServerController.getInstance().deleteMagacin((Magacin) request.getData());
                    break;
                case Operation.GET_ALL_PAKOVANJE:
                    response.setData(ServerController.getInstance().getAllPakovanje());
                    break;
                 case Operation.ADD_PAKOVANJE:
                    ServerController.getInstance().addPakovanje((Pakovanje) request.getData());
                    break;
                case Operation.UPDATE_PAKOVANJE:
                    ServerController.getInstance().updatePakovanje((Pakovanje) request.getData());
                    break;
                case Operation.DELETE_PAKOVANJE:
                    ServerController.getInstance().deletePakovanje((Pakovanje) request.getData());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
