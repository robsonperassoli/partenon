package br.com.syspartenon.partenon.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.com.syspartenon.partenon.domain.Foto;
import br.com.syspartenon.partenon.domain.Galeria;
import br.com.syspartenon.partenon.persistence.FotoDAO;
import br.com.syspartenon.partenon.util.FileUtil;
import br.com.syspartenon.partenon.util.UniqId;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@BusinessController
public class FotoBC extends DelegateCrud<Foto, Integer, FotoDAO> {
    public List<Foto> findAll(Galeria galeria) {
        return getDelegate().findAll(galeria);
    }    
    
    public void insert(Foto foto, byte[] imgContent, String fileName) {
        try {
            String filename = UniqId.getInstance().getUniqIDHashString() + "." + FileUtil.getExtension(fileName);
            String filePath = FileUtil.getImgDir() + filename;
            String filePathThumb = FileUtil.getThumbDir() + filename;

            BufferedImage bfImg = org.alfredlibrary.utilitarios.io.Imagem.obterBufferedImage(imgContent);
            BufferedImage bfImagem = org.alfredlibrary.utilitarios.io.Imagem.redimensionar(bfImg, 500, 300, true);
            BufferedImage bfThumb = org.alfredlibrary.utilitarios.io.Imagem.redimensionar(bfImg, 150, 100, true);

            org.alfredlibrary.utilitarios.io.Imagem.salvarImagem(bfImagem, filePath);
            org.alfredlibrary.utilitarios.io.Imagem.salvarImagem(bfThumb, filePathThumb);

            foto.setFotNome(filename);
            super.insert(foto);
        } catch (Exception e) {
            Logger.getLogger("FotoBC").log(Level.SEVERE,e.getMessage());
        }

    }
}
