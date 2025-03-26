@Service
public class ReportService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public byte[] generateServiceOrderReport(Long osId) throws IOException {
        ServiceOrder order = serviceOrderRepository.findById(osId)
            .orElseThrow(() -> new ResourceNotFoundException("Ordem de serviço não encontrada"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();
        document.add(new Paragraph("Relatório da Ordem de Serviço #" + order.getOsNumber()));
        document.add(new Paragraph("Máquina: " + order.getMachine().getDescription()));
        document.close();

        return outputStream.toByteArray();
    }
}