package org.codingevents.codingevents.controllers;

import org.attoparser.trace.MarkupTraceEvent;
import org.codingevents.codingevents.data.EventData;
import org.codingevents.codingevents.models.Event;
import org.codingevents.codingevents.models.EventTypes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("events")
public class EventControllers {

    @GetMapping
    public String firstMethod(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute(new Event());
        model.addAttribute("types", EventTypes.values());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEvent(@ModelAttribute @Valid  Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            return "events/create";

        }
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEvent(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";

    }

    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here
    }

    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
    }


}


