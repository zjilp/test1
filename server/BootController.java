@RestController
public class BootController implements BootApi {
    private static Logger log = LogManager.getLogger(BootController.class);
    @Autowired
    private BootService bootService;

    /**
     * <p> Boot form request.</p>
     * <p>Expected HTTP GET and request '/edit'.</p>
     * @return
     */
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam(required=false) Long id) {
        log.debug("edit");
        ModelAndView mv = new ModelAndView();
        if (id == null) {
            mv.addObject("boot", new Boot());
        } else {
            mv.addObject("boot", bootService.findById(id));
        }
        mv.setViewName("edit-boot");
        return mv;
    }

    /**
     * <p>Saves a {@link Boot}.</p>
     *
     * <p>Expected HTTP POST and request '/save'.</p>
     * @return
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Boot boot, Model model) { // Der Parameter Model ist nicht notwendig
        // Die Felder des Html Formulars müssen mit den Instanzenvariablen des Objekts
        // Boot übereinstimmen
        if (boot.getCreated() == null) { // Wenn das Feld created der Instanz boot null ist,
            // dann wird das aktuelle Datum in dieses Feld geschrieben
            boot.setCreated(LocalDateTime.now());
        }
        bootService.save(boot);
        return "redirect:findAll";
    }

    /**
     * <p>Deletes a Boot.</p>
     * <p>Expected HTTP GET and request '/delete'.</p>
     */
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public ModelAndView delete(@RequestParam(required=true) Long id) {
        try {
            bootService.delete(id);
            return new ModelAndView("redirect:findAll");
        } catch (DaoException e) {
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", e.getMessage());
            return mv;
        }
    }

    /**
     * <p>Searches for all boats and returns them in a
     * <code>Collection</code>.</p>
     *
     * <p>Expected HTTP GET and request '/findAll'.</p>
     */
    @RequestMapping(value="/findAll", method=RequestMethod.GET)
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "Boote");
        mv.addObject("message", "Alle Boote des Vereins");
        mv.addObject("boote", bootService.findAll());
        mv.addObject("edit", true);
        mv.setViewName("list-boote");
        return mv;
    }

    /**
     * <p>Searches for all free foats and returns them in a
     * <code>Collection</code>.</p>
     *
     * <p>Expected HTTP GET and request '/freieBoote'.</p>
     */
    @RequestMapping(value="/freieBoote", method=RequestMethod.GET)
    public ModelAndView freieBoote() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "Fahrt beginnen");
        mv.addObject("message", "Folgende Boote sind für eine Fahrt verfügbar. Wählen Sie ein Boot aus:");
        mv.addObject("boote", bootService.findFreie());
        mv.addObject("edit", false);
        mv.setViewName("list-boote");
        return mv;
    }

    @Operation(summary = "List all boats", description = "Mit dieser Methode können Sie die Liste von im System integrierten Booten laden.")
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public List<Boot> rest_list() {
        return bootService.findAll();
    }

    /**
     * Create or modify a specific boat
     * @param boot The Boat to create / modify
     * @return Success or error
     */
    @Operation(summary = "Create or modify a boat")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description="Das Boot was gespeichert werde soll")
    @RequestMapping(value="/", method={RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public ResponseEntity<Boot> rest_save(
            @RequestBody Boot boot
    ) {
        // Wenn das Feld created der Instanz boot null ist,
        // dann wird das aktuelle Datum in dieses Feld geschrieben
        if (boot.getCreated() == null) {
            boot.setCreated(LocalDateTime.now());
        }
        Boot b = bootService.save(boot);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(b.getId())
                .toUri();

        return ResponseEntity.created(uri).body(b);
    }

    @Operation(summary = "Delete a boat by it's id")
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> rest_delete(@PathVariable Long id) {
        try {
            bootService.delete(id);
            return ResponseEntity.ok("Deleted Boot " + id);
        } catch (DaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Get a boat by id")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boot> rest_get(@PathVariable Long id) {
        return ResponseEntity.ok(bootService.findById(id));
    }

}

