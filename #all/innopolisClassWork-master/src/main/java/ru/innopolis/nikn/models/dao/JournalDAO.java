package ru.innopolis.nikn.models.dao;

import ru.innopolis.nikn.models.entities.Journal;

import java.util.List;

/**
 * Created by Nikolay on 28.11.2016.
 */
public interface JournalDAO {

    public List<Journal> findAll();

    public boolean createJournalRow(Journal journal);

}
