package br.unitins.tp1.service.imagem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.unitins.tp1.model.ecommerce.Teclado;
import br.unitins.tp1.repository.TecladoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import br.unitins.tp1.validation.ValidationException;

@ApplicationScoped
public class TecladoFileServiceImpl implements FileService {

        private final String PATH_USER = System.getProperty("user.home")
        + File.separator + "quarkus"
        + File.separator + "images"
        + File.separator + "Teclado" + File.separator;

        @Inject
        public TecladoRepository tecladoRepository;


    @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Teclado teclado = tecladoRepository.findById(id);

        try {
            teclado.setNomeImagem(salvarImagem(nomeImagem, imagem));
        } catch (Exception e) {
            throw new ValidationException("imagem", e.getMessage());
        }
    }

    private String salvarImagem(String nomeImagem, byte[] imagem) throws IOException{
        // verificar o tipo da imagem
        String mimeType = Files.probeContentType(new File(nomeImagem).toPath());
            List<String> listMimeType = Arrays.asList("image/jpg", "image/gif", "image/png", "image/jpeg");
                if (!listMimeType.contains(mimeType)) 
            throw new IOException("Tipo de imagem não suportado.");

        // verificar o tamanho do arquivo - nao permitir maior que 10mb
        if (imagem.length > 1024 * 1024 * 10) {
            throw new IOException("Arquivo muito grande, tamanho máximo 10mb.");
    }

     // criar pasta quando nao existir
     File diretorio = new File(PATH_USER);
     if (!diretorio.exists()) 
         diretorio.mkdirs();

    // gerar nome do arquivo 
        String nomeArquivo = UUID.randomUUID() 
                                + "." 
                                + mimeType.substring(mimeType.lastIndexOf("/") + 1);
        String path = PATH_USER + nomeArquivo;

        // salvar o arquivo
        File file = new File(path);
        if (file.exists())
          throw new IOException("Este arquivo ja existe. Programador, tu deve melhorar esse codigo");

        // criar o arquivo no SO
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);
        fos.flush();
        fos.close();

        return nomeArquivo;
    }

    @Override
    public File download(String nomeImagem) {
        return new File(PATH_USER + nomeImagem);
    }
    
}
